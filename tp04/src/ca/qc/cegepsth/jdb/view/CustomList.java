package ca.qc.cegepsth.jdb.view;

import java.util.ArrayList;

import ca.qc.cegepsth.jdb.R;
import ca.qc.cegepsth.jdb.model.EvenementJournal;
import ca.qc.cegepsth.jdb.model.Note;
import ca.qc.cegepsth.jdb.model.Photo;
import ca.qc.cegepsth.jdb.model.Punch;
import android.R.string;
import android.app.Activity;
import android.graphics.Picture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList extends ArrayAdapter<String> {
	private final Activity context;

	private final ArrayList<EvenementJournal> ListeEvenementJournal;
	
	public CustomList(Activity context, ArrayList<EvenementJournal> listEJ) {
		super(context, R.layout.list_single);
			this.context = context;
			this.ListeEvenementJournal = listEJ;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
LayoutInflater inflater = context.getLayoutInflater();
		
		View rowView;
		EvenementJournal ej = ListeEvenementJournal.get(position);
		rowView= inflater.inflate(R.layout.list_single, null, true); // On lui donne le Row à utiliser PAR DEFAULT
		
		// Section qui décide de quel inflater on utilise
		// Un inflater est la partie logiciel qui "pitch" le bon rowview à la bonne place
		//Dans ce cas-ci nous avons 2 types de rowview. Celui pour les punchin, les notes, etc. 
		//et celui qui met une photo en grand plan.
		/*
		if (ej instanceof Note) {
			Note note = (Note) ej;
			rowView= inflater.inflate(R.layout.list_single, null, true); // On lui donne le Row à utiliser
			}
		else if (ej instanceof Punch) {
			Punch punch = (Punch) ej;
			rowView= inflater.inflate(R.layout.list_single, null, true); // On lui donne le Row à utiliser
			}
		else if (ej instanceof Photo) {
			Photo photo = (Photo) ej;
			//TODO utiliser un autre xml de rowview
			rowView= inflater.inflate(R.layout.list_photo, null, true); // On lui donne le Row à utiliser
			}
		else {
			//GERER L'ERREUR ! 
		}
		
		// on recupere les champs
		TextView txtTitle = (TextView) rowView.findViewById(R.id.Title);
		TextView txtContent = (TextView) rowView.findViewById(R.id.txt);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		
		TextView titlePhotoView = (TextView) rowView.findViewById(R.id.TitlePhotoTextView);
		ImageView photoview = (ImageView) rowView.findViewById(R.id.imageView1);
		
		// Section qui assigne les bonnes variables au bon rowview. 
		//on ne pouvait pas les assigner avant car elle n'était pas initialisé. (section ci haut).
		//Charles :)
		
		if (ej instanceof Note) {
			Note note = (Note) ej;
			rowView= inflater.inflate(R.layout.list_single, null, true); // On lui donne le Row à utiliser
			txtTitle.setText(note.Title);
			txtContent.setText(note.Note);
			imageView.setImageResource(R.drawable.ic_launcher);
		}
		else if (ej instanceof Punch) {
			Punch punch = (Punch) ej;
			rowView= inflater.inflate(R.layout.list_single, null, true); // On lui donne le Row à utiliser
			txtTitle.setText("[Punch Event]");
			txtContent.setText(String.valueOf(punch.isPunchedIn));
			imageView.setImageResource(R.drawable.ic_launcher);
		}
		else if (ej instanceof Photo) {
			Photo photo1 = (Photo) ej;
			//todo utiliser un autre xml de rowview
			rowView= inflater.inflate(R.layout.list_photo, null, true); // On lui donne le Row à utiliser
			titlePhotoView.setText(photo1.Title);
			photoview.setImageResource(R.drawable.ic_launcher);
		}
		else {
			//GERER L'ERREUR ! 
		}
		*/
		
		
		//POUR TEST
		TextView txtTitle = (TextView) rowView.findViewById(R.id.Title);
		TextView txtContent = (TextView) rowView.findViewById(R.id.txt);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
		txtTitle.setText("HELLO THIS IS A TITLE");
		txtContent.setText("My name is Content");
		imageView.setImageResource(R.drawable.ic_launcher);
	return rowView;
	}
}
