package _00_IntroToStacks;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel.
	 * 
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 */

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<Character> chars = new Stack<>();

	void setup() {
		frame.setVisible(true);
		frame.addKeyListener(this);
		panel.add(label);
		frame.add(panel);
		frame.pack();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String g = label.getText();
		StringBuilder stri = new StringBuilder(g);
		char h = e.getKeyChar();

		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			chars.push(g.charAt(g.length() - 1));
			stri.delete(g.length() - 1, g.length());
			g = stri.toString();
			label.setText(g);
			frame.pack();

		} else if (e.getKeyCode() == KeyEvent.VK_Z) {
			g += chars.pop();
			label.setText(g);
			frame.pack();

		} else {

			g += h;
			label.setText(g);
			frame.pack();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void run() {
		// TODO Auto-generated method stub
		setup();
	}
}
