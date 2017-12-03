package question2;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Question2 extends JFrame{
	
	public Question2(int heigth, int width)
	{
		super.setTitle("Smile");
		super.setSize(heigth, width);
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null);
		
	}
	public static void main(String[] args)
	{
		new Question2(400, 400);
	}	
	
	
	public void paint(Graphics g)
	{
		//g.drawArc(100, 100, 200, 200, 0, 360);
		g.setColor(Color.gray);
		g.fillRect(0, 0, 400, 400);
		g.setColor(Color.YELLOW);
		g.fillArc(100, 100, 200, 200, 0, 360);
		g.setColor(Color.BLUE);
		g.fillArc(140, 150, 40, 40, 0, 360);
		g.fillArc(220, 150, 40, 40, 0, 360);
		g.drawLine(200,150,200,220);
		g.setColor(Color.red);
		g.drawArc(160, 180, 80, 80, 200, 140);
	}
}
