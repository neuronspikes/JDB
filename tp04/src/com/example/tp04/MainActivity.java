package com.example.tp04;

import com.example.tp04putain.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static Journal jdb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        if(jdb == null){// Un peu le "First Launch"
        	jdb = new Journal("Journal1"); // On crée un nouveau Journal
	        jdb.Path = getFilesDir(); // On lui donne la variable du Path où on enregistre les fichiers
        }
         
        // Loader les sessions de travail précédente
        //jdb.JournaldeBord = jdb.loadFromDevice(); 
        //Afficher une Toast le nombre d'événement dans le Journal | Facultatif
        Toast toast;
		Context context = this;
		String text;
		text = ("Nombre d'evenement au Journal : " + String.valueOf(MainActivity.jdb.size()));
		toast = Toast.makeText(context, text, 1);
		toast.setGravity(Gravity.TOP, 0, 15);
		toast.show();
        
	}
	
	/**
	*
	* @author Charles Perreault
	*
	* Méthode qui part l'Activité TimeTrack
	*/
    public void mTimeTrack(View view) {
    	Intent intent = new Intent (this, TimeTrackActivity.class); 
    	startActivity(intent);
    }
    
	/**
	*
	* @author Charles Perreault
	*
	* Méthode qui part l'activité ReadLog
	*/
    public void mReadLog(View view) {
    	Intent intent = new Intent (this, ReadLogActivity.class); 
   
    	startActivity(intent);
    }

	/**
	*
	* @author Charles Perreault
	*
	* Méthode qui part l'activité d'écriture dans le journal
	*/
    public void mWriteLog(View view) {
    	//Determiner si on peut ecrire
    	if (PunchedIn()) { // si on est PUNCHÉ ACTIF, ALORS ON PEUT TRAVAILLER ET ECRIRE DANS LE JOURNAL
    		Intent intent = new Intent (this, WriteLogActivity.class); //on part l'activité
        	startActivity(intent);
		} else {
			Toast toast;
			Context context = this;
			String text;
			text = ("Vous devez avoir punché IN pour écrire dans le journal"); //qui est écrit ça dessus
			toast = Toast.makeText(context, text, 1);
			toast.setGravity(Gravity.TOP, 0, 15);
			toast.show();
		}
    }
    
	/**
	*
	* @author Anthony Pugliese
	*
	* Vérifie dans la liste si le dernier élément est un punch IN 
	*/
    private boolean PunchedIn(){
    	if(!MainActivity.jdb.JournaldeBord.isEmpty()){//Si
			evenementJournal dernierEnevement =	MainActivity.jdb.findLastEvent();
			if(dernierEnevement.type == 1){ //c'est un punch in
				return true;
			}
    	}
			return false;
    }
    
	/**
	*
	* @author Charles Perreault, Anthony Pugliese
	*
	* 
	*/
	/*private boolean PunchedInOrFalse(){
		/*
		 *  Event Type
		 * 	Type 0 = Undefined Event Type (or RAW)
		 *  Type 1 = PunchIn
		 *  Type 2 = PunchOut Event
		 *  Type 3 = Comment Or Note Event
		 *  Type 4 = other
		 * 
		 
		evenementJournal ejPunchedIN;
		evenementJournal ejPunchedOut;
		ejPunchedIN = jdb.findLastEvent(1);
		ejPunchedOut = jdb.findLastEvent(2);
		
		//Regarde si les valeures ne sont pas null pour éviter les erreures
		if(ejPunchedIN != null && ejPunchedOut != null){
		long l_ejPI = Long.parseLong(ejPunchedIN.Data);
		long l_ejPO = Long.parseLong(ejPunchedOut.Data);
		
		if (l_ejPI >= l_ejPO) {
			return true;
		}
		}
		//Les valeures sont nulls ou punchIn < punchOut
		return false;
		
	}
    */
	
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
