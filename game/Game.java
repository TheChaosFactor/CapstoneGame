package game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import framework.KeyInput;
import framework.ObjectId;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private boolean running = false;
	public static int WIDTH, HEIGHT;
	private Handler handler;

	public Game() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		new GameWindow(800, 640, "The A-Maze-Ing Game", this);
	}
	
	private void init() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		handler.createLevel();
	}
	
	public synchronized void start() {
		if (running)
			return;

		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	public void tick() {
		handler.tick();
		for (int i = 0; i < handler.object.size(); i++) {
			if (handler.object.get(i).getId() == ObjectId.Block) {
				return;
			}
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long lastTimer = System.currentTimeMillis();
		double nsPerTick = 1000000000D / 60D;
		double delta = 0;
		int ticks = 0;
		int frames = 0;

		init();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;

			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				//System.out.println(ticks + " ticks , " + frames + " frames per second");
				frames = 0;
				ticks = 0;
			}
		}
	}



	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, getWidth(), getHeight());
		handler.render(g);
		g.dispose();
		bs.show();
		
	}

	public static void main(String[] args) {
		new Game().start();
	}

}
