package ca.qc.cegepsth.jdb.view;

import ca.qc.cegepsth.jdb.R;
import ca.qc.cegepsth.jdb.R.id;
import ca.qc.cegepsth.jdb.R.layout;
import ca.qc.cegepsth.jdb.R.menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;

public class CalendarActivity extends Activity {
	CalendarView calendar;
	EditText Nom;
	EditText Description;
	EditText Lieu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar);
		/** @author Charles **/
		calendar = (CalendarView) findViewById(R.id.calendar); // on initialise
																// le Calendrier
		Nom = (EditText) findViewById(R.id.Event_Txt);
		Description = (EditText) findViewById(R.id.edit_Description);
		Lieu = (EditText) findViewById(R.id.edit_lieu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar, menu);
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

	/**
	 * TODO Generer l'ajout d'evenement à une Date
	 */
	public void DatePicked(View view) {
		// TODO essayer de voir le calendrier à la date choisi
	}

	public void returnToMainActivity(View view) {
		Intent intent = new Intent(this, MainActivity.class);

		startActivity(intent);
	}

	/**
	 * @author Charles
	 * @param view
	 */
	public void BTaddEvent(View view) {
		// Variables a enregistrer
		String Ename;
		String Eplace;
		String Edescription;
		long EBtime;
		long EEtime;

		// On va chercher les valeurs
		Ename = Nom.getText().toString();
		Eplace = Lieu.getText().toString();
		Edescription = Description.getText().toString();
		EBtime = calendar.getDate(); // l'evenement par là.
		EEtime = (calendar.getDate() + 3600000); // evenement de 1 heure

		// on ajoute l'evenement

		Intent intent = MainActivity.jdb.ch.addEvent(Ename, Edescription,
				Eplace, "", EBtime, EEtime);
		startActivity(intent);
	}
}
