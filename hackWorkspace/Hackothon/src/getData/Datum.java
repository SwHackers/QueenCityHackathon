package getData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

public class Datum
{
	private double number;
	private boolean blank = false;
	
	private boolean isNumber = false;
	
	public static int holeCount;
	
	public Datum(FormulaEvaluator fe, HSSFCell cell)
	{
		try
		{
			CellType ct = fe.evaluateInCell(cell).getCellTypeEnum();
			
			switch (ct)
			{
				case BLANK:		blank	= true; holeCount++;			break;
				case NUMERIC:	number	= cell.getNumericCellValue(); isNumber = true;	break;
				case BOOLEAN:
					if (cell.getBooleanCellValue())
						number = 1;
					else
						number = 0;
					break;
				default:		blank	= true; holeCount++;			break;
			}
		}
		catch(Exception e)
		{
			blank = true;
		}
	}
	
	public double getValue()
	{
		return this.number;
	}
	
	public boolean isBlank()
	{
		return this.blank;
	}
	
	public boolean getIsNumber() {return this.isNumber; }
}
