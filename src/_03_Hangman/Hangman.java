package _03_Hangman;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hangman {
	JFrame frame;
	JPanel panel;
	JLabel label;
public static void main(String[] args) {
	
}
void setup() {
	 frame = new JFrame();
	 panel = new JPanel();
	 label = new JLabel();
	 frame.setVisible(true);
	 panel.add(label);
	 frame.add(panel);
	 frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	 frame.pack();
	
}
}
