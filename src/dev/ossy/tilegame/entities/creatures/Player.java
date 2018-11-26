package dev.ossy.tilegame.entities.creatures;

import dev.ossy.tilegame.Handler;
import dev.ossy.tilegame.gfx.Animation;
import dev.ossy.tilegame.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

	//Animation
	private Animation animDown, animUp, animLeft, animRight;


	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		//Sets the boundingBox of the player separate from the rest of the creatures
		bounds.x = 20;
		bounds.y = 32;
		bounds.width = 24;
		bounds.height = 32;

		//Animation
		animDown = new Animation(500,Assets.player_down);
		animUp = new Animation(500, Assets.player_up);
		animLeft = new Animation(500, Assets.player_left);
		animRight = new Animation(500, Assets.player_right);
	}

	@Override
	public void tick() {
		//Animation
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();

		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			yMove = -speed;
		}
		if (handler.getKeyManager().down) {
			yMove = speed;
		}
		if (handler.getKeyManager().left) {
			xMove = -speed;
		}
		if (handler.getKeyManager().right) {
			xMove = speed;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

		/*
		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);
		*/
	}

	private BufferedImage getCurrentAnimationFrame(){
		if (xMove < 0){
			return animLeft.getCurrentFrame();

		}else if (xMove > 0){
			return animRight.getCurrentFrame();
		}else if (yMove < 0){
			return animUp.getCurrentFrame();
		}else if (yMove > 0){
			return animDown.getCurrentFrame();
		}else {
			return Assets.player;
		}
	}
}
