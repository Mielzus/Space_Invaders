import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PixelInvaders extends JFrame{
	
	public PixelInvaders(){
		GamePanel panel = new GamePanel();		
		panel.addKeyListener(new KeyListener(){
			
			public void keyPressed(KeyEvent e){
				panel.passPressedKey(e.getKeyCode());
			}
			public void keyReleased(KeyEvent e){
				panel.passReleasedKey(e.getKeyCode());
			}
			public void keyTyped(KeyEvent e){}
		});
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		this.add(panel);
	}
	
	public static void main(String[] args){
		PixelInvaders frame = new PixelInvaders();
		frame.setSize(1000, 700);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}