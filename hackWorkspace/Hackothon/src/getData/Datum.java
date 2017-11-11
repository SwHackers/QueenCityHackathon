package getData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class Datum
{
	String string;
	double number;
	boolean blank = false;
	boolean bool;
	
	public static int holeCount;
	
	public Datum(FormulaEvaluator fe, HSSFCell cell)
	{
		try
		{
			CellType ct = fe.evaluateInCell(cell).getCellTypeEnum();
			
			switch (ct)
			{
				case BLANK:		blank	= true; holeCount++;			break;
				case NUMERIC:	number	= cell.getNumericCellValue();	break;
				case STRING:	string	= cell.getStringCellValue();	break;
				case BOOLEAN:	bool	= cell.getBooleanCellValue();	break;
				default:		blank	= true; holeCount++;			break;
			}
		}
		catch(Exception e)
		{
			blank = true;
		}
	}
}
