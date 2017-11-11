package getData;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class ExcelReader
{
	private int numOfRows;
	
	Entry[] entries;
	
	public ExcelReader()
	{
		File trafficBook = new File("resource/Cleaned_Traffic_Data_2.xls");
		
		if (!trafficBook.exists())
			System.out.println("File does not exist");
		
		try
		{
			POIFSFileSystem	fs = new POIFSFileSystem(new FileInputStream(trafficBook));
			HSSFWorkbook	wb = new HSSFWorkbook(fs);
			HSSFSheet		sheet = wb.getSheetAt(0);
			
			HSSFRow			row = sheet.getRow(0);
			
			FormulaEvaluator fe = wb.getCreationHelper().createFormulaEvaluator();
			
			numOfRows = sheet.getPhysicalNumberOfRows();
			entries = new Entry[numOfRows];
			
			for (int i = 1; i < 100; i++)	//TODO this should be numOfRows
			{
				row = sheet.getRow(i);
				entries[i] = new Entry(fe, row);
			}
			
			wb.close();
		}
		catch (Exception e)
		{
			System.out.println("@ExcelReader: error, getting rows didn't work");
		}
	}
}
