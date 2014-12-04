package ca.qc.cegepsth.jdb.view;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import ca.qc.cegepsth.jdb.R;
import ca.qc.cegepsth.jdb.model.EvenementJournal;

public class ReadLogActivity extends Activity {

	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayList<EvenementJournal> listDesEvenements = new ArrayList<EvenementJournal>();

		for (Iterator<EvenementJournal> evenements = MainActivity.jdb.JournaldeBord
				.iterator(); evenements.hasNext();) {
			EvenementJournal event = evenements.next();

			listDesEvenements.add(event);
		}

		setContentView(R.layout.activity_read_log);

		CustomList adapter = new CustomList(ReadLogActivity.this,
				listDesEvenements);
		list = (ListView) findViewById(R.id.rl_lv);
		list.setAdapter(adapter);
		/*
		 * list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		 * 
		 * @Override public void onItemClick(AdapterView<?> parent, View view,
		 * int position, long id) { Toast.makeText(ReadLogActivity.this,
		 * "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show(); } });
		 */
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