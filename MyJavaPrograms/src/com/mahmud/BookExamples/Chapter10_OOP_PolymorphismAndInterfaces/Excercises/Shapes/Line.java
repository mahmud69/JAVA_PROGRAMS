package com.mahmud.BookExamples.Chapter10_OOP_PolymorphismAndInterfaces.Excercises.Shapes;

public class Line {

	private Point p1 = new Point ();
	private Point p2 = new Point ();
	
	Line ()
	{
		initializePoint (p1);
		initializePoint (p2);
		
	}
	
	Line (Point p1, Point q)
	{
		initializePoint (p1);
		initializePoint (p2);
		
	}
	
	public void initializePoint (Point p)
	{
		p.setX(0);
		p.setY(0);
		p.setZ(0);
		
	}
	
	public double length()
	{
		
		double temp;
		
		temp = Math.sqrt( Math.pow((p1.getX() - p2.getX()) , 2.0 ) +
						  Math.pow((p1.getY() - p2.getY()) , 2.0 ) +
						  Math.pow((p1.getZ() - p2.getZ()) , 2.0 )); 
		
		return temp;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    Line l1 = new Line();
	    l1.p1.setX(2);
	    l1.p1.setY(1);
	    l1.p1.setZ(4);
	    
	    l1.p2.setX(4);
	    l1.p2.setY(5);
	    l1.p2.setZ(8);
	    
	    System.out.println ("Point " + l1.p1);
	    System.out.println ("Point " + l1.p2);
	    
	    
	    System.out.println("Length of Line L1 = " + l1.length());
	    //System.out.println(Math.sqrt(Math.pow(2.0, 3.0)));
	}
	

}
