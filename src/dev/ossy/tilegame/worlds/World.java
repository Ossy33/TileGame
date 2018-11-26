package dev.ossy.tilegame.worlds;

import dev.ossy.tilegame.Handler;
import dev.ossy.tilegame.entities.Entity;
import dev.ossy.tilegame.entities.EntityManager;
import dev.ossy.tilegame.entities.creatures.Player;
import dev.ossy.tilegame.entities.statics.Tree;
import dev.ossy.tilegame.tiles.Tile;
import dev.ossy.tilegame.utils.Utils;

import java.awt.*;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] worldTiles;
	//Entities
	private EntityManager entityManager;


	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 200, 200));
		entityManager.addEntity(new Tree(handler, 100, 250));

		loadWorld(path);

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);

	}

	public void tick() {
		entityManager.tick();
	}

	public void render(Graphics g) {

		//Math.max returns the largest number
		//This is making the screen only render the tiles we can see.
		int xStart = Math.max(0, (int) handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = Math.min(width, (int) (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = Math.max(0, (int) handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = Math.min(height, (int) (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));

			}
		}
		//Entities
		entityManager.render(g);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;
		}

		Tile t = Tile.tiles[worldTiles[x][y]];
		if (t == null) {
			return Tile.grassTile;
		} else {
			return t;
		}

	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);

		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		worldTiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				worldTiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
