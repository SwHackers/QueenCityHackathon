package getData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class Entry
{
	//This is for traffic data
	Datum[] rawData;
	
	public Entry(FormulaEvaluator fe, HSSFRow row)
	{
		try
		{
			HSSFCell cell;
			
			int maxCols = row.getPhysicalNumberOfCells();
			
			rawData = new Datum[maxCols];
			
			for(int i = 0; i < maxCols; i++)
			{
				try
				{
					cell = row.getCell(i);
					rawData[i] = new Datum(fe, cell);
				}
				catch (Exception e)
				{
					System.out.println("@Entry: error, i = " + i);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("@Entry: error getting cell data.");
		}
	}
	
	private void normalize()
	{
		
	}
}
