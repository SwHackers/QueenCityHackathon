package getData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader
{
	private static int numOfRows;
	private static int numOfCols;
	
	Entry[] entries;
	
	public ExcelReader()
	{
		File trafficBook = new File("resource/traffic.csv");
		
		try
		{
			POIFSFileSystem	fs = new POIFSFileSystem(new FileInputStream(trafficBook));
			HSSFWorkbook	wb = new HSSFWorkbook(fs);
			HSSFSheet		sheet = wb.getSheetAt(0);
			
			
		}
		catch (Exception e)
		{
			
		}
	}
}
