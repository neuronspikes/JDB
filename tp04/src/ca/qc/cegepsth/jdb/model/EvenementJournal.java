package ca.qc.cegepsth.jdb.model;
import java.util.Calendar;
import java.util.Locale;

import android.text.format.DateFormat;


public class EvenementJournal {
	public int ID; //unique
	public long Timestamp;
	
	//Constructeur
	public EvenementJournal(){
		//Il n'y a pas vraiment de constucteur ici puisque on le fait plus tard..
		
	}
	
	/**
	*
	* @author Charles Perreault
	*
	* Retourne une String avec la Date et l'heure
	*/
	private String getDate(long time) {
	    Calendar cal = Calendar.getInstance(Locale.ENGLISH); 
	    cal.setTimeInMillis(time);
	    String date = DateFormat.format("dd-MM-yyyy h:mm:ss a", cal).toString();
	    return date;
	}
	
	/**
	*
	* @author Charles Perreault
	*
	* Retourne une String avec toutes les données non formatées
	*/
	public String toString()
	{
		return (getDate(Timestamp));
	}

	
}
