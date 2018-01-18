package framework;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataStream.MathStream;
import game.Handler;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	private JFrame frame = new JFrame("Math-o-Matic");
	private JLabel label = null;
	private JPanel panel = new JPanel();
	private int seed = 0;
	private MathStream maths = new MathStream();
	private Random rand = new Random();
	private JTextField answerLbl = new JTextField("");

	public KeyInput(Handler handler) {
		this.handler = handler;
		
		maths.initializeArrays();

		Dimension dime = new Dimension(400, 400);

		frame.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.setSize(dime);
		frame.setMinimumSize(dime);
		frame.setMaximumSize(dime);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Change to DO_NOTHING_ON_CLOSE
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		seed = rand.nextInt(5);

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
						} else if (handler.object.get(i - 25).getId() == ObjectId.GEM) {
							label = new JLabel(maths.getProb(seed));
							label.setAlignmentX(Component.CENTER_ALIGNMENT);
							answerLbl.setBounds(50, 100, 200, 30);

							panel.add(label);
							panel.add(answerLbl);
							frame.pack();
							frame.setVisible(true);
						}
					}
				} else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					if (i < 425) {
						if (handler.object.get(i + 25).getId() == ObjectId.PATH) {
							handler.object.get(i + 25).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
							key = 22;
						} else if (handler.object.get(i + 25).getId() == ObjectId.GEM) {
							label = new JLabel(maths.getProb(seed));
							label.setAlignmentX(Component.CENTER_ALIGNMENT);
							answerLbl.setBounds(50, 100, 200, 30);

							panel.add(label);
							panel.add(answerLbl);
							frame.pack();

							frame.setVisible(true);
						}
					}
				} else if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					if (i % 25 > 1) {
						if (handler.object.get(i - 1).getId() == ObjectId.PATH) {
							handler.object.get(i - 1).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
						} else if (handler.object.get(i - 1).getId() == ObjectId.GEM) {
							label = new JLabel(maths.getProb(seed));
							label.setAlignmentX(Component.CENTER_ALIGNMENT);
							answerLbl.setBounds(50, 100, 200, 30);

							panel.add(label);
							panel.add(answerLbl);
							frame.pack();

							frame.setVisible(true);
						}
					}
				} else if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					if (i % 25 < 24) {
						if (handler.object.get(i + 1).getId() == ObjectId.PATH) {
							handler.object.get(i + 1).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
							key = 34;
						} else if (handler.object.get(i + 1).getId() == ObjectId.GEM) {
							label = new JLabel(maths.getProb(seed));
							label.setAlignmentX(Component.CENTER_ALIGNMENT);
							answerLbl.setBounds(50, 100, 200, 30);


							panel.add(label);
							panel.add(answerLbl);
							frame.pack();

							frame.setVisible(true);
						}
					}
				} // end if (which key pressed) statement
			} // end if (id == player) statement
		} // End for loop

		if (key == KeyEvent.VK_ENTER) {
			String answer = null;
			answer = answerLbl.getText();
			
			try {
				int numAns = Integer.parseInt(answer);
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
			}
			
			
			
		}
		
	} // End keyPressed method

	public void keyReleased(KeyEvent e) {
		// Do nothing here
	}

}
