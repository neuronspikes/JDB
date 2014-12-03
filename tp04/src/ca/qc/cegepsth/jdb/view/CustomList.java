package ca.qc.cegepsth.jdb.view;

import java.util.ArrayList;

import ca.qc.cegepsth.jdb.R;
import ca.qc.cegepsth.jdb.model.EvenementJournal;
import ca.qc.cegepsth.jdb.model.PunchIn;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {
	private final Activity context;

	private final ArrayList<EvenementJournal> ej;
	
	public CustomList(Activity context, ArrayList<EvenementJournal> EvJo) {
		super(context, R.layout.list_single);
			this.context = context;
			this.ej = EvJo;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView= inflater.inflate(R.layout.list_single, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.Title);
		TextView txtContent = (TextView) rowView.findViewById(R.id.txt);
		//TODO faire un switch pour trouver la méthode d'affichage.
		//ej.get(1).
			
		
		
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		txtTitle.setText(ej.get(position).toString());
		txtContent.setText(String.valueOf(ej.get(position).Timestamp));
		//imageView.setImageResource(imageId[position]);
	return rowView;
	}
}
