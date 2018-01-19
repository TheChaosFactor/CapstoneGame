package framework;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataStream.MathStream;
import game.Game;
import game.Handler;

public class KeyInput implements ActionListener, KeyListener {

	private Handler handler;
	private JFrame frame = new JFrame("Math-o-Matic");
	private JLabel label = new JLabel("");
	private JPanel panel = new JPanel();
	private int seed = 0;
	private MathStream maths = new MathStream();
	private Random rand = new Random();
	private JTextField answerBox = new JTextField(20);
	private JButton submitBtn = new JButton("Submit Answer!");
	private int currentPos = 0;
	private String whichDirection = "";
	
	public KeyInput(Handler handler) {
		this.handler = handler;

		maths.initializeArrays();

		Dimension dime = new Dimension(400, 100);

		frame.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		frame.setSize(dime);
		frame.setMinimumSize(dime);
		frame.setMaximumSize(dime);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		seed = rand.nextInt(15);

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
							label.setText(maths.getProb(seed));
							label.setAlignmentX(Component.CENTER_ALIGNMENT);
							currentPos = i;
							whichDirection = "up";
							submitBtn.addActionListener(this);

							panel.add(label);
							panel.add(answerBox);
							panel.add(submitBtn);
							frame.pack();
							frame.setVisible(true);
						} else if (handler.object.get(i - 25).getId() == ObjectId.EXIT) {
							// If the block above the player is the exit then
							if (Game.canExit) {
								// If the requirement for the Gems has been reached
								JLabel temp = new JLabel("");
								JLabel exitLbl = new JLabel("");
								panel.remove(answerBox);
								panel.remove(submitBtn);
								temp.setText("You've collected all the Gems and made it to the exit!");
								exitLbl.setText("You can now close this window to exit the game");
								frame.setTitle("You win!");
								label.setText("Congratulations!");
								exitLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
								label.setAlignmentX(Component.CENTER_ALIGNMENT);
								temp.setAlignmentX(Component.CENTER_ALIGNMENT);

								panel.add(label);
								panel.add(temp);
								panel.add(exitLbl);
								frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame.setVisible(true);
							}
						}
					}
				} else if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
					if (i < 425) {
						if (handler.object.get(i + 25).getId() == ObjectId.PATH) {
							handler.object.get(i + 25).setId(ObjectId.PLAYER);
							tempObject.setId(ObjectId.PATH);
							key = 22;
						} else if (handler.object.get(i + 25).getId() == ObjectId.GEM) {
							label.setText(maths.getProb(seed));
							label.setAlignmentX(Component.CENTER_ALIGNMENT);
							currentPos = i;
							whichDirection = "down";
							submitBtn.addActionListener(this);

							panel.add(label);
							panel.add(answerBox);
							panel.add(submitBtn);
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
							label.setText(maths.getProb(seed));
							label.setAlignmentX(Component.CENTER_ALIGNMENT);
							currentPos = i;
							whichDirection = "left";
							submitBtn.addActionListener(this);

							panel.add(label);
							panel.add(answerBox);
							panel.add(submitBtn);
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
							label.setText(maths.getProb(seed));
							label.setAlignmentX(Component.CENTER_ALIGNMENT);
							currentPos = i;
							whichDirection = "right";
							submitBtn.addActionListener(this);

							panel.add(label);
							panel.add(answerBox);
							panel.add(submitBtn);
							frame.pack();

							frame.setVisible(true);
						}
					}
				} // end if (which key pressed) statement
			} // end if (id == player) statement
		} // End for loop

	} // End keyPressed method

	public void keyReleased(KeyEvent e) {
		// Do nothing here
	}

	public void actionPerformed(ActionEvent event) {
		String answer = null;
		answer = answerBox.getText();

		if (answer.equals(""))
			return;
		
		try {
			int numAns = Integer.parseInt(answer);

			if (maths.checkAnswer(seed, numAns)) {
				Game.gemCount++;

				if (Game.gemCount == 1)
					Game.canExit = true;

				if (whichDirection.equals("up")) {
					handler.object.get(currentPos - 25).setId(ObjectId.PLAYER);
					handler.object.get(currentPos).setId(ObjectId.PATH);
				} else if (whichDirection.equals("down")) {
					handler.object.get(currentPos + 25).setId(ObjectId.PLAYER);
					handler.object.get(currentPos).setId(ObjectId.PATH);
				} else if (whichDirection.equals("left")) {
					handler.object.get(currentPos - 1).setId(ObjectId.PLAYER);
					handler.object.get(currentPos).setId(ObjectId.PATH);
				} else if (whichDirection.equals("right")) {
					handler.object.get(currentPos + 1).setId(ObjectId.PLAYER);
					handler.object.get(currentPos).setId(ObjectId.PATH);
				} else {

				}

				whichDirection = "";
				answerBox.setText("");
				submitBtn.removeActionListener(this);
				frame.setVisible(false);
			} else {

				if (whichDirection.equals("up")) {
					randomizeGemLoc(currentPos - 25);
				} else if (whichDirection.equals("down")) {
					randomizeGemLoc(currentPos + 25);
				} else if (whichDirection.equals("left")) {
					randomizeGemLoc(currentPos - 1);
				} else if (whichDirection.equals("right")) {
					randomizeGemLoc(currentPos + 1);
				}

				whichDirection = "";
				answerBox.setText("");
				answerBox.repaint();
				frame.setVisible(false);
			}

		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		}

	}

	public void keyTyped(KeyEvent e) {

	}

	public void randomizeGemLoc(int gemLoc) {
		int possibleTiles = 0;
		int otherTiles = 0;
		int newLoc = 0;

		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ObjectId.PATH)
				possibleTiles++;
			else
				otherTiles++;
		}

		newLoc = rand.nextInt(possibleTiles + otherTiles);

		while (handler.object.get(newLoc).getId() != ObjectId.PATH) {
			newLoc = rand.nextInt(possibleTiles + otherTiles);
		}

		handler.object.get(newLoc).setId(ObjectId.GEM);
		handler.object.get(gemLoc).setId(ObjectId.PATH);

	}

} // End of the KeyInput Class
