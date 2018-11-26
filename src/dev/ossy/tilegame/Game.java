package dev.ossy.tilegame;

import dev.ossy.tilegame.display.Display;
import dev.ossy.tilegame.gfx.Assets;
import dev.ossy.tilegame.gfx.GameCamera;
import dev.ossy.tilegame.input.KeyManager;
import dev.ossy.tilegame.input.MouseManager;
import dev.ossy.tilegame.states.GameState;
import dev.ossy.tilegame.states.MenuState;
import dev.ossy.tilegame.states.State;


import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	//States
	public State gameState;
	public State menuState;

	//Input
	private KeyManager keyManager;
	private MouseManager mouseManager;

	//Camera
	private GameCamera gameCamera;

	//Handler
	private Handler handler;

	public Game(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init() {
		display = new Display(title, width, height);
		//Allows us to use the keyboard.
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);

		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);


		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(menuState);

	}


	private void tick() {
		keyManager.tick();

		if (State.getState() != null) {
			State.getState().tick();

		}
	}

	private void render() {
		//A buffer which is a screen behind the screen
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!

		if (State.getState() != null) {
			State.getState().render(g);
		}

		//End Drawing!

		bs.show();
		g.dispose();
	}

	public void run() {
		init();
		//The amount of time we want to call tick() and render() method every second.
		int fps = 60;
		//The time per frame in ns.
		double timePerTick = 1000000000 / (double) fps;
		//The amount of time we have to call the tick() and render() method again.
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		//How many times the tick() and render() methods were called.
		int ticks = 0;

		while (running) {
			//Current time of our computer in nanoseconds.
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			//if true we have to tick() and render().
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}

			//Checks if the timer has exceeded 1 second
			if (timer >= 1000000000) {
				System.out.println("Ticks: " + ticks);
				ticks = 0;
				timer = 0;
			}

		}
		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager(){
		return mouseManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public synchronized void start() {

		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
