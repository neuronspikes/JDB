package ca.qc.cegepsth.jdb.model;

import ca.qc.cegepsth.jdb.view.MainActivity;

public class PunchOut extends EvenementJournal {
	
	public PunchOut() {
		super();
		super.Data = "[PUNCH OUT]";
		super.Timestamp = System.currentTimeMillis();
		if (MainActivity.jdb.size() == 0) {
			//alors la liste est vide
			//il est donc le premier ID
			super.ID = 1;
		}
		else
		{
			int size = (MainActivity.jdb.size() + 1);
			super.ID = size;
		}
	}
}
