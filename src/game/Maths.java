package game;

public class Maths 
{

	public static boolean insideRectangle(int x, int y, int x2, int y2, int size)
	{
		boolean b = false;
		
		if(x2 > x && y2 > y && x2 <= x + size && y2 <= y + size)
			b = true;
		
		return b;
	}
}
