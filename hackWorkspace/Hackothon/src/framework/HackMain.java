package framework;

import java.awt.Color;

import javax.swing.JFrame;

import getData.ExcelReader;
import mathStuff.PMath;

public class HackMain
{
	static ExcelReader er;
	
	public static void main(String[] args)
	{
		er = new ExcelReader();
		
		PMath.normalize(er.getData());
		
//		MLModel m = new MLModel(er.getData());
		
		//printData(er);
		
		int w = 600;
		int h = 600;
		
		JFrame frame = new JFrame();
		framework.Panel panel = new Panel(er.getData(), w, h);
		
		frame.add(panel);
		frame.pack();
		frame.setSize(w, h);
		frame.setTitle("Hackathon");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setBackground(Color.BLACK);
		panel.repaint();
		
		System.out.println("Terminated");
	}
	
	@SuppressWarnings("unused")
	private static void printData(ExcelReader er)
	{
		//Testing data
		for (int r = 0; r < er.getData().length - 1; r++)
		{
			for (int c = 0; c < er.getData()[r].length; c++)
			{
				System.out.print(" " + er.getData()[r][c]);
			}
			System.out.println();
		}
	}
}
