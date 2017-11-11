package framework;

import getData.ExcelReader;
import mathStuff.PMath;

public class HackMain
{
	static ExcelReader er;
	
	public static void main(String[] args)
	{
		er = new ExcelReader();
		
		PMath.normalize(er.getData());
		
		printData(er);
		
		System.out.println("Terminated");
	}
	
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
