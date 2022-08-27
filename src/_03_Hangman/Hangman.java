package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	String readRandom;
	String findLetters;
public static void main(String[] args) {
	Hangman hang = new Hangman();
	hang.setup();
}
void setup() {
	readRandom = Utilities.readRandomLineFromFile("dictionary.txt");
	JOptionPane.showMessageDialog(null, "This is hangman: type in a letter and see if it is part of the full word.");
	frame = new JFrame();
	 panel = new JPanel();
	 label = new JLabel();
	 frame.setVisible(true);
	 findLetters = "";
	 for (int i = 0; i < readRandom.length(); i++) {
		findLetters += "_";
	}
	 label.setText(findLetters);
	 panel.add(label);
	 frame.add(panel);
	 frame.addKeyListener(this);
	 frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	 frame.pack();
	
}
@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	char getK = arg0.getKeyChar();
	System.out.println(getK);
	if((getK>= 65 && getK <= 90) || (getK >= 97 && getK <= 122)) {
		getK = Character.toLowerCase(getK);
		readRandom = readRandom.toLowerCase();
		for (int i = 0; i < readRandom.length(); i++) {
			if(readRandom.charAt(i) == getK) {
				StringBuilder build = new StringBuilder(findLetters);
				build.setCharAt(i, getK);
				findLetters = build.toString();
				if(getK >= readRandom.length()+4) {
					JOptionPane.showMessageDialog(null, "Game Over!");
				}
			}
		} 
		label.setText(findLetters);
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
}
