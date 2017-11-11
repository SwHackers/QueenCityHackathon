package framework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import mathStuff.PMath;

public class Panel extends JPanel
{
	private static final long serialVersionUID = 1L;

	double[][] data;
	
	int w;
	int h;
	
	public Panel(double[][] data, int w, int h)
	{
		this.data = data;
		
		this.w = w;
		this.h = h;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		for (int r = 0; r < 60000; r++)
		{
			double xD = data[r][7];
			double yD = data[r][8];
			
			int x = (int)PMath.map(xD, -1, 1, 0, w);
			int y = (int)(h - PMath.map(yD, -1, 1, 0, h));
			
			double cl = data[r][4];
			int c = (int)PMath.map(cl, -1, 1, 0, 255);
			
			int red = (int) (255-c + c*0.1);
			int gre = (int) (255-c + c*0.1);
			int blu = c;
			
			g2.setColor(new Color(red, gre, blu));
			
			g2.fillRect((int)x, (int)y, 1, 1);
		}
	}
	
	private Color calcColor(int c)
	{
		Color color;
		
		if (c < 0.33)
			color = Color.red;
		else if (c < 0.67)
			color = Color.yellow;
		else
			color = Color.green;
		
		return color;
	}
}
