package getData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Entry
{
	//This is for traffic data
	String[] columns = new String[66];
	private static int numOfRows;
	
	public Entry(int rowIndex, HSSFSheet sheet)
	{
		File trafficBook = new File("resource/traffic.csv");
		
		try
		{
			HSSFRow			row = sheet.getRow(rowIndex);
			HSSFCell		cell;
			
			int rows = sheet.getPhysicalNumberOfRows();
			
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
