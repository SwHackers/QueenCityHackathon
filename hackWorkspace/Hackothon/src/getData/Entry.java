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
	
	public Entry()
	{
		File trafficBook = new File("resource/traffic.csv");
		
		try
		{
			POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(trafficBook));
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;
			HSSFCell cell;
			
			int rows = sheet.getPhysicalNumberOfRows();
			
			
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
