package mathStuff;

public class PMath
{
	public static double map(double value, double min1, double max1, double min2, double max2)
	{
		double result;
		
		double range1 = max1 - min1;
		double range2 = max2 - min2;
		
		double frac = (value - min1)/range1;
		
		result = min2 + frac*range2;
		
//		System.out.println("v, m1, m1, m2, m2 = " + value + " " + min1 + " " + max1 + " " + min2 + " " + max2 + " " + result);
		
		return result;
	}
	
	public static void normalize(double[][] data)
	{		
		for (int c = 0; c < data[0].length; c++)
		{
			double min = data[0][c];
			double max = data[0][c];
			
			for (int r = 0; r < data.length; r++)
			{
				double v = data[r][c];
				if (v < min)
					min = v;
				if (v > max)
					max = v;
			}
			
			for (int r = 0; r < data.length; r++)
			{
				data[r][c] = map(data[r][c], min, max, -1, 1);
			}
		}
	}
}
