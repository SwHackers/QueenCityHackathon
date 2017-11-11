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
	
	private static final int debugRows = 100;
	
	private double[][] data;// = new double[100][15];	//Rows with columns of data
	
	public ExcelReader()
	{
		File trafficBook = new File("resource/Cleaned_Traffic_Data_2.xls");
		
		if (!trafficBook.exists())
			System.out.println("File does not exist");
		
		int ii = 0;
		
		try
		{
			POIFSFileSystem	fs = new POIFSFileSystem(new FileInputStream(trafficBook));
			HSSFWorkbook	wb = new HSSFWorkbook(fs);
			HSSFSheet		sheet = wb.getSheetAt(0);
			
			HSSFRow			row = sheet.getRow(0);
			
			FormulaEvaluator fe = wb.getCreationHelper().createFormulaEvaluator();
			
			numOfRows = sheet.getPhysicalNumberOfRows();
			entries = new Entry[numOfRows];
			
			data = new double[debugRows][15];
			
			//First row to get data width
			
//			List<Double> firstRow = new ArrayList<>(Arrays.asList());
			
			boolean[] validSpots = new boolean[25];
			
			row = sheet.getRow(1);
			entries[1] = new Entry(fe, row, validSpots, true);
			
			for (int i = 0; i < debugRows - 1; i++)	//TODO this should be numOfRows
			{
				ii = i;
				row = sheet.getRow(i + 1);
				entries[i] = new Entry(fe, row, data[i], validSpots);
			}
			
			wb.close();
		}
		catch (Exception e)
		{
			System.out.println("@ExcelReader: error, getting rows didn't work; ii = " + ii);
			e.printStackTrace();
		}
	}
	
	public double[][] getData() { return this.data; }
}
