import java.util.ArrayList;

import processing.core.PApplet;

public class TableFrame extends PApplet
{	
	public static final int FRAME_SIZE = 600;
	private ArrayList<Philosopher> philosopherList;
	private ArrayList<Fork> forkList;
	
	/*
	public TableFrame(ArrayList<Philosopher> philosopherList, ArrayList<Fork> forkList)
	{
		this.philosopherList = philosopherList;
		this.forkList = forkList;
		PApplet.main("TableFrame");
	} */
	
	public static void main(String[] args)
	{
		PApplet.main("TableFrame");

	}
	
	public void settings()
	{
        size(FRAME_SIZE, FRAME_SIZE);
    }

    public void setup()
    {
        rectMode(CENTER);
    	fill(120,50,240);
    }

    public void draw()
    {
    	polygon(FRAME_SIZE/2, FRAME_SIZE/2, 250, 10);
    }
    
    private void polygon(float x, float y, float radius, int npoints)
    {
    	  float angle = TWO_PI / npoints;
    	  beginShape();
    	  for (float a = 0; a < TWO_PI; a += angle)
    	  {
    	    rect(x + cos(a) * radius, y + sin(a) * radius, 20, 20);
    	    
    		/*  
    		float sx = x + cos(a) * radius;
    	    float sy = y + sin(a) * radius;
    	    vertex(sx, sy);*/
    	  }
    	  endShape(CLOSE);
	}

}
