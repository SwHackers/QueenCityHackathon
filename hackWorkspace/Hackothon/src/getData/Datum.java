package getData;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class Datum
{
	String string;
	double number;
	boolean blank = false;
	
	public Datum(HSSFCell cell)
	{
		switch (cell.getCellTypeEnum())
		{
		case BLANK: blank = true;
			break;
		case NUMERIC: number = cell.getNumericCellValue();
			break;
		case STRING: string = cell.getStringCellValue();
			break;
//		case BOOLEAN:
//			break;
//		case ERROR:
//			break;
//		case FORMULA:
//			break;
//		case _NONE:
//			break;
		default:
			System.out.println("@Datum: warning cell type was defult");
			break;
		}
	}
}
