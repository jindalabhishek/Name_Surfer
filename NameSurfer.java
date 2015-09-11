/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {

	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the top of the window.
	 */
	public void init() {
	    // You fill this in, along with any helper methods //
		b1 = new JButton("Graph");
		b2 = new JButton("Clear");
		t = new JTextField(10);
		l = new JLabel("Name:");
		add(l,NORTH);
		add(t,NORTH);
		add(b1,NORTH);
		add(b2,NORTH);
		addActionListeners();
		t.addActionListener(this);
		n = new NameSurferDataBase(NAMES_DATA_FILE);
		graph = new NameSurferGraph(); 
		add(graph); 
		
	}

	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		// You fill this in //
		String cmd=e.getActionCommand();
		if(e.getSource()==t || cmd.equals("Graph"))
			{
			 String s=(t.getText().substring(0,1)).toUpperCase()+(t.getText().substring(1,(t.getText()).length())).toLowerCase();
			 NameSurferEntry n1 = n.findEntry(s);
				 graph.addEntry(n1);
			     graph.update();
			}
		if(cmd.equals("Clear"))
			graph.clear();
		
	}
	public JButton b1,b2;
	public JTextField t;
	public JLabel l;
	public NameSurferDataBase n;
	private NameSurferGraph graph; 
}
