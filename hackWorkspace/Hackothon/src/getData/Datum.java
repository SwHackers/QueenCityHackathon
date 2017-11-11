package getData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class Datum
{
	String string;
	double number;
	boolean blank = false;
	
	public Datum(FormulaEvaluator fe, HSSFCell cell)
	{
		try
		{
			CellType ct = fe.evaluateInCell(cell).getCellTypeEnum();
			
			switch (ct)
			{
				case BLANK:		blank = true;	break;
				case NUMERIC:	number = cell.getNumericCellValue();	break;
				case STRING:	string = cell.getStringCellValue();		break;
				default:		blank = true;	break;
			}
		}
		catch(Exception e)
		{
			blank = true;
		}
	}
}
