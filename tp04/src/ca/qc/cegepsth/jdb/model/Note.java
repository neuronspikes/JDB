package ca.qc.cegepsth.jdb.model;

import ca.qc.cegepsth.jdb.view.MainActivity;

public class Note extends EvenementJournal {
	public String Title;
	public String Note;
	
	public Note(String _title, String _note)
	{
		super();
		this.Title = _title;
		this.Note = _note;
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
	
	@Override
	public String toString()
	{
		String str;
		str = Title + " : " + Note;
		return str;
	}
	

	
}
