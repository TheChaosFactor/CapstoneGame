package framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import game.Handler;

public class KeyInput extends KeyAdapter {

	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if (tempObject.getId() == ObjectId.PLAYER) {

				// If the user presses 'W' or UP on the keyboard
				if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {

					if (i > 25) { // Makes sure that were are not on the top row

						if (handler.object.get(i - 25).getId() == ObjectId.PATH) {
							// If the block above the player is a path then swap position
							
							handler.object.get(i - 25).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
						}
					}
				} else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					if (i < 425) {
						if (handler.object.get(i + 25).getId() == ObjectId.PATH) {
							handler.object.get(i + 25).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
							key = 22;
						}
					}
				} else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					if (i % 25 > 1) {
						if (handler.object.get(i - 1).getId() == ObjectId.PATH) {
							handler.object.get(i - 1).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
						}
					}
				} else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					if (i % 25 < 24) {
						if (handler.object.get(i + 1).getId() == ObjectId.PATH) {
							handler.object.get(i + 1).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
							key = 34;
						}
					}
				} // end if (which key pressed) statement
			} // end if (id == player) statement
		} // End for loop

	} // End keyPressed method

	@Override
	public void keyReleased(KeyEvent e) {
		// Do nothing here
	}

}
