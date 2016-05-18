import java.awt.*;
import javax.swing.*;

public class PixelInvaders extends JFrame{
	
	public PixelInvaders(){
		GamePanel panel = new GamePanel();
		this.add(panel);
	}
	
	public static void main(String[] args){
		PixelInvaders frame = new PixelInvaders();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}