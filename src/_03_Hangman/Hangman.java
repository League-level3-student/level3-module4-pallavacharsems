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
	JLabel labe;
	String readRandom;
	String findLetters;
	int lives = 0;
	int txlives;
	int gotRight = 0;
public static void main(String[] args) {
	Hangman hang = new Hangman();
	hang.setup();
	
}
void setup() {
	 readRandom = Utilities.readRandomLineFromFile("dictionary.txt");
	 txlives = readRandom.length()+4;
	JOptionPane.showMessageDialog(null, "This is hangman: type in a letter and see if it is part of the full word.");
	frame = new JFrame();
	 panel = new JPanel();
	 label = new JLabel();
	 labe = new JLabel();
	 frame.setVisible(true);
	 findLetters = "";
	 for (int i = 0; i < readRandom.length(); i++) {
		findLetters += "_";
	}
	 formatLabel();
	 panel.add(label);
	 panel.add(labe);
	 frame.add(panel);
	 frame.addKeyListener(this);
	 frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	 labe.setText(" You have "+txlives + " lives!");
	 frame.pack();
	
}
@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	lives+=1;
	txlives-=1;
	labe.setText(" You have "+txlives + " lives!");
	
			if(lives>=readRandom.length()+4) {
		JOptionPane.showMessageDialog(null, "Game Over!");
		int ync = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
		if(ync == 0) {
			frame.dispose();
			setup();
		} else {
			System.exit(0);
		}
	}
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
				if(findLetters == readRandom) {
					int b = JOptionPane.showConfirmDialog(null, "You Got It Right! Would You Like To Restart?!");
					if(b == 0) {
						frame.dispose();
						setup();
					} else {
						System.exit(0);
					}
				}
				//if(getK >= readRandom.length()+4) {
					//JOptionPane.showMessageDialog(null, "Game Over!");
					//int ync = JOptionPane.showConfirmDialog(null ,"Would you like to restart?");
					//if(ync == 0) {
						//setup();
					//} else {
					//	System.exit(0);
					//}
				//}
			}
		} 
		formatLabel();
	}
}
void formatLabel() {
	String labelText = "";
	for (int i = 0; i < findLetters.length(); i++) {
		labelText+= findLetters.charAt(i) + " ";
		
	}
	label.setText(labelText);
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
