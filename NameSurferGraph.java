/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;
import acm.util.RandomGenerator;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	 * Creates a new NameSurferGraph object that displays the data.
	 */
	public NameSurferGraph() {
		addComponentListener(this);
		// You fill in the rest //
	}
	
	
	/**
	 * Clears the list of name surfer entries stored inside this class.
	 */
	public void clear() {
		// You fill this in //
		removeAll();
		e=null;
		update();
		
	}
	
	/* Method: addEntry(entry) */
	/**
	 * Adds a new NameSurferEntry to the list of entries on the display.
	 * Note that this method does not actually draw the graph, but
	 * simply stores the entry; the graph is drawn by calling update.
	 */
	public void addEntry(NameSurferEntry entry) {
		// You fill this in //
		e=entry;
		for(int i=0;i<12;i++)
			{
			 arr[i]=(double)(entry.getRank(i));
		     if(arr[i]==0.0)
		    	 arr[i]=(997.0/560.0)*(-GRAPH_MARGIN_SIZE-GRAPH_MARGIN_SIZE+APPLICATION_HEIGHT);
			}
			
	}
	
	
	/**
	 * Updates the display image by deleting all the graphical objects
	 * from the canvas and then reassembling the display according to
	 * the list of entries. Your application must call update after
	 * calling either clear or addEntry; update is also called whenever
	 * the size of the canvas changes.
	 */
	public void update() {
		// You fill this in //
		GLine ub = new GLine(0,GRAPH_MARGIN_SIZE,APPLICATION_WIDTH,GRAPH_MARGIN_SIZE);
		GLine lb = new GLine(0,-GRAPH_MARGIN_SIZE+APPLICATION_HEIGHT,APPLICATION_WIDTH,-GRAPH_MARGIN_SIZE+APPLICATION_HEIGHT);
		add(ub);
		add(lb);
		int j=2;
		int decade=1900;
		for(int i=0;i<12;i++)
		{
			GLine l = new GLine(j,0,j,APPLICATION_HEIGHT);
			GLabel label = new GLabel(""+decade,j,APPLICATION_HEIGHT);
			add(l);
			add(label);
			j=j+(APPLICATION_WIDTH/12);
			decade+=10;
		}
		j=2;
		for(int i=0;i<11;i++)
		{	
			l1 = new GLine(j,GRAPH_MARGIN_SIZE+(arr[i]*(560.0/997.0)),j+(APPLICATION_WIDTH/12),GRAPH_MARGIN_SIZE+(arr[i+1]*(560.0/997.0)));
			j=j+(APPLICATION_WIDTH/12);	
			add(l1);
		}
		j=2;
		Color color=rgen.nextColor();
		for(int i=0;i<12;i++)
		{

			if(e!=null)
			{label = new GLabel(e.getName()+" "+e.getRank(i),j,GRAPH_MARGIN_SIZE+(arr[i]*(560.0/997.0)));
			add(label);
			label.setColor(color);
			if(e.getRank(i)==0)
				label.setLabel(e.getName()+"*");
			j=j+(APPLICATION_WIDTH/12);	
		    }
		}
	}
	GLine l1;
	GLabel label;
	public double[] arr = new double[12];
	public NameSurferEntry e;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
}
