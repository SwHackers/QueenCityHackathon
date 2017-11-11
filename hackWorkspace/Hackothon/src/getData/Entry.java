package getData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class Entry
{
	//This is for traffic data
//	String[] rawData;
	double[] rawDataD;
	Datum[] rawData;
	
	public Entry(HSSFRow row)
	{
		try
		{
			HSSFCell cell;
			
			int maxCols = row.getPhysicalNumberOfCells();
			
			//rawData = new String[maxCols];
			rawData = new Datum[maxCols];
			
//			for(int i = 0; i <= maxCols; i++)
//			{
//				cell = row.getCell(i);
//				rawData[i] = new Datum(cell);
//			}
			
		}
		catch (Exception e)
		{
			System.out.println("@Entry: error getting cell data");
		}
	}
}
