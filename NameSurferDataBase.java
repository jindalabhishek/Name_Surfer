import java.io.*;
import acm.program.*;
import acm.util.*;
import java.util.*;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase extends Program implements NameSurferConstants {
	
	/* Constructor: NameSurferDataBase(filename) */
	/**
	 * Creates a new NameSurferDataBase and initializes it using the
	 * data in the specified file.  The constructor throws an error
	 * exception if the requested file does not exist or if an error
	 * occurs as the file is being read.
	 */
	public NameSurferDataBase(String filename) {
		// You fill this in //
		BufferedReader rd = open(filename);
		try
		{
			while(true)
			{
				String line = rd.readLine();
				if(line==null)
					break;
				NameSurferEntry entry = new NameSurferEntry(line);
				slist.put(entry.getName(),entry);
			}
			rd.close();
		}
		catch(IOException ex)
		{
			throw new ErrorException(ex);
		}
	}
	private BufferedReader open(String p)
	{
		BufferedReader rd = null;
		while(rd==null)
		{
			try{
				rd = new BufferedReader(new FileReader(p));
			}
			catch(IOException ex)
			{
				println("hello");
			}
		}
		return rd;
	}
	
	/* Method: findEntry(name) */
	/**
	 * Returns the NameSurferEntry associated with this name, if one
	 * exists.  If the name does not appear in the database, this
	 * method returns null.
	 */
	public NameSurferEntry findEntry(String name) {
		// You need to turn this stub into a real implementation //
		return slist.get(name);
		//return null;
	}
	public Map<String,NameSurferEntry> slist = new HashMap<String,NameSurferEntry>();
}

