package ca.qc.cegepsth.jdb.view;

import java.util.ArrayList;
import java.util.Iterator;

import ca.qc.cegepsth.jdb.R;
import ca.qc.cegepsth.jdb.R.id;
import ca.qc.cegepsth.jdb.R.layout;
import ca.qc.cegepsth.jdb.R.menu;
import ca.qc.cegepsth.jdb.model.EvenementJournal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReadLogActivity extends Activity {
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_log);
		lv = (ListView) findViewById(R.id.rl_lv);
		ArrayList<EvenementJournal> listDesEvenements = new ArrayList<EvenementJournal>(); //pour naviger dans la liste

		for (Iterator<EvenementJournal> evenements = MainActivity.jdb.JournaldeBord // notion de generique, type generique
				.iterator(); evenements.hasNext();) {
			EvenementJournal event = evenements.next();
			if (event.type == 1) { // Si c'est un punch in on ajoute dans son
									// data [PUNCH IN]
				event.Data = "[PUNCH IN]";
			} else if (event.type == 2) {
				event.Data = "[PUNCH OUT]";
			}
			listDesEvenements.add(event);
			lv.setAdapter(new ArrayAdapter<EvenementJournal>(this,
					android.R.layout.simple_list_item_1, listDesEvenements));
		}

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
