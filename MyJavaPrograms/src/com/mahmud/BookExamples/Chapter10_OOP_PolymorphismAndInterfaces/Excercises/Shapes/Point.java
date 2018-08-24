package com.mahmud.BookExamples.Chapter10_OOP_PolymorphismAndInterfaces.Excercises.Shapes;

public class Point {

	private int x; //x Coordinate;
	private int y; //y Coordinate;
	private int z; //z Coordinate;
	
	
	
	public Point ()
	{
		x = y = z = 0;
	}
	
	public Point (int xVal, int yVal)
	{
		x = xVal;
		y = yVal;
		z = 0;
	}

	public Point (int xVal, int yVal, int zVal)
	{
		x = xVal;
		y = yVal;
		z = zVal;
	}
	
	public int getX ()
	{
		return x;
	}
	
	public void setX (int xVal)
	{
		x = xVal;
	}
	
	public int getY ()
	{
		return y;
	}
	
	public void setY (int yVal)
	{
		y = yVal;
	}
	
	public int getZ()
	{
		return z;
	}
	
	public void setZ (int zVal)
	{
		z = zVal;
	}
	

	// return String representation of Point
	@Override // indicates that this method overrides a superclass method
	public String toString()
	{
		return String.format(
				"%s: %d %s: %d %s: %d", "x coordinate = ", x,
										"y coordinate = ", y,
										"z coordinate = ", z );
		
	} // end method toString
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point p  = new Point (1, 2, 3);
		System.out.println("Point P = " + p);
	}

	
}
