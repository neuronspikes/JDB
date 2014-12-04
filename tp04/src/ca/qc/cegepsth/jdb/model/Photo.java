package ca.qc.cegepsth.jdb.model;

import java.io.FileOutputStream;
import java.io.IOException;

import ca.qc.cegepsth.jdb.view.MainActivity;

import android.graphics.Bitmap;

public class Photo extends EvenementJournal {
	public String Title;
	public Bitmap bitmap;
	
	public Photo(String _title, Bitmap _bitmap)
	{
		this.Title = _title;
		this.bitmap = _bitmap;
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
		
		FileOutputStream out = null;
		try {
		    out = new FileOutputStream(Title);
		    bitmap.compress(Bitmap.CompressFormat.PNG, 30, out); // bmp is your Bitmap instance
		    // PNG is a lossless format, the compression factor (100) is ignored
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (out != null) {
		            out.close();
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}
}
