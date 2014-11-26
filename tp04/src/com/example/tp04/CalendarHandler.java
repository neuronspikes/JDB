package com.example.tp04;

import java.util.Calendar;

import android.content.Intent;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;

public class CalendarHandler {
	
	Calendar beginTime;
	Calendar endTime;
	
	CalendarHandler()
	{
		// Par défault, on initialise des valeurs sûres, soit les variables temporelles
		beginTime = Calendar.getInstance();
		beginTime.setTimeInMillis(System.currentTimeMillis());
		
		endTime = Calendar.getInstance();
		endTime.setTimeInMillis(System.currentTimeMillis() + 10000);
	}
	/**{@code startActivity(ch.addEvent("Cour de Java", "Cours de Java", "B-2346", "email.address@des.personnes.invitees", temps de depart en miliss, tempsdefinenmiliss));}**/
	public Intent addEvent(String _titre, String _description,
			String _emplacement, String _extraEmail, long _beginTime, long _endTime)
	{
		if (_beginTime == 0) {
			_beginTime = this.beginTime.getTimeInMillis();
		}
		if (_endTime == 0) {
			_endTime = this.endTime.getTimeInMillis();
		}
		
		Intent intent = new Intent(Intent.ACTION_INSERT)
    	    .setData(Events.CONTENT_URI)
    	    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, _beginTime)
    	    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, _endTime)
    	    .putExtra(Events.TITLE, _titre)
    	    .putExtra(Events.DESCRIPTION, _description)
    	    .putExtra(Events.EVENT_LOCATION, _emplacement)
    	    .putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY)
    	    .putExtra(Intent.EXTRA_EMAIL, _extraEmail);
		return intent;
	}
		
		
		
	}
