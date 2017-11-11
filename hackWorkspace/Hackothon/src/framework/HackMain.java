package framework;

import getData.Datum;
import getData.ExcelReader;

public class HackMain
{
	public static void main(String[] args)
	{
		ExcelReader er = new ExcelReader();
		
		System.out.println("Hole = " + Datum.holeCount);

		System.out.println("Terminated");
	}
}
