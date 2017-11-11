package getData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class Entry
{
	//This is for traffic data
	Datum[] rawData;
	
	public Entry(FormulaEvaluator fe, HSSFRow row, double[] data, boolean[] validSpots)
	{
		int col = 0;
		
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
					//data[i] = rawData[i].getValue();
					
					if (validSpots[i])
					{
						data[col] = rawData[i].getValue();
						
//						System.out.println("raw = " + rawData[i].getValue());
						
						col++;
					}
					
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
	
	public Entry(FormulaEvaluator fe, HSSFRow row, boolean[] validSpots, boolean firstOne)
	{
		try
		{
			HSSFCell cell;
			
			int maxCols = row.getPhysicalNumberOfCells();
			
			rawData = new Datum[maxCols];
			
//			System.out.println("Length = " + maxCols);
			
			for(int i = 0; i < maxCols; i++)
			{
				try
				{
					cell = row.getCell(i);
					rawData[i] = new Datum(fe, cell);
					
					if (!rawData[i].isBlank())
					{
						validSpots[i] = true;
//						data.add(rawData[i].getValue());
					}
					else
						validSpots[i] = false;
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
	
}
