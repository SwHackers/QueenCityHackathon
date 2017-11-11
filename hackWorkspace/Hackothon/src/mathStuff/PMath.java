package mathStuff;

public class PMath
{
	public static double map(double value, double min1, double max1, double min2, double max2)
	{
		double result;
		
		double range1 = max1 - min1;
		double frac = value/range1;
		
		double range2 = max2 - min2;
		result = min2 + frac*range2;
		
		return result;
	}
}
