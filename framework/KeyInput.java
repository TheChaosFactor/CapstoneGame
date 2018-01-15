package framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Handler;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ObjectId.PLAYER) {
				// Key Events for player
				
				float xPos = tempObject.getX();
				float yPos = tempObject.getY();
				
				
				
				if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
					if (i > 25){
						if (handler.object.get(i - 25).getId() == ObjectId.PATH) {
							handler.object.get(i - 25).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
						}
					}
				}
				else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					if (i < 414) {
						if (handler.object.get(i + 25).getId() == ObjectId.PATH) {
							handler.object.get(i + 25).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
							key = KeyEvent.VK_STOP;
						}
					}
				}
				else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					if (i % 25 > 1) {
						if (handler.object.get(i - 1).getId() == ObjectId.PATH) {
							handler.object.get(i - 1).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
						}
					}
				}
				else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					if (i % 25 < 24) {
						if (handler.object.get(i + 1).getId() == ObjectId.PATH){
							handler.object.get(i + 1).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
							key = KeyEvent.VK_STOP;
						}
					}
				}
			}
		}

		System.out.println(key);
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
	}

}
