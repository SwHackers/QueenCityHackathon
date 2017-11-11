package getData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader
{
	private int numOfRows;
	
	Entry[] entries;
	
	public ExcelReader()
	{
		File trafficBook = new File("resource/traffic_3.xls");
		
		if (!trafficBook.exists())
			System.out.println("File does not exist");
		
		try
		{
			POIFSFileSystem	fs = new POIFSFileSystem(new FileInputStream(trafficBook));
			HSSFWorkbook	wb = new HSSFWorkbook(fs);
			HSSFSheet		sheet = wb.getSheetAt(0);
			
			HSSFRow			row = sheet.getRow(0);
			
			numOfRows = sheet.getPhysicalNumberOfRows();
			entries = new Entry[numOfRows];
			
			for (int i = 0; i < numOfRows; i++)
			{
				row = sheet.getRow(i);
				entries[i] = new Entry(row);
			}
			
			wb.close();
		}
		catch (Exception e)
		{
			System.out.println("@ExcelReader: error, getting rows didn't work");
		}
	}
}