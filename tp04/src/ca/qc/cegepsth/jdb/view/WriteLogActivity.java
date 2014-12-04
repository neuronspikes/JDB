package ca.qc.cegepsth.jdb.view;

import java.io.FileNotFoundException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import ca.qc.cegepsth.jdb.R;
import ca.qc.cegepsth.jdb.model.Photo;

public class WriteLogActivity extends Activity {

	EditText mEdit;

	// Variables pour photo. Francis Marion
	private final int width = 350;
	private final int height = 512;
	private static final int _RESULTAT_IMAGE_GALLERIE = 10;
	private static final int _RESULTAT_IMAGE_NOUVELLE = 20;
	private ImageView imageSelectionner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write_log);

		// Donne l'acces et le nom de imageview.
		imageSelectionner = (ImageView) findViewById(R.id.imageSelectionner);
	}

	public void ReturnToMain(View view) {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}

	public void addNote(View view) {
		mEdit = (EditText) findViewById(R.id.wl_tb_text);

		ca.qc.cegepsth.jdb.model.Note note;
		note = new ca.qc.cegepsth.jdb.model.Note(mEdit.getText().toString(),
				mEdit.getText().toString());
		MainActivity.jdb.JournaldeBord.add(note);

		// Écrit le journal sur l'appareil
		MainActivity.jdb.saveToDevice(this);

		// Affiche le nombre d'évènements dans le journal dans un toast
		Toast toast;
		Context context = this;
		String text;
		text = ("Nombre d'evenement au Journal : " + String
				.valueOf(MainActivity.jdb.size()));
		toast = Toast.makeText(context, text, 1);
		toast.setGravity(Gravity.TOP, 0, 15);
		toast.show();
		this.ReturnToMain(view);
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
	 * Methode pour aller vers la gallerie photo
	 * 
	 * @author Francis Marion
	 */
	public void onClickImageExistante(View v) {
		// On veut aller chercher une photo dans la gallerie et l'intent est un
		// ACTION_PICK.
		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);

		// Donne l'endroit où l'image sera entreposé.
		String path = Environment.getExternalStoragePublicDirectory(
				Environment.DIRECTORY_PICTURES).getPath();

		// Convertis en URI.
		Uri picturesDirectory = Uri.parse(path);

		// Montre où est le data et quelle type de fichier il s'agit (ici tout
		// les sortes d'images).
		photoPickerIntent.setDataAndType(picturesDirectory, "image/*");

		// Commence l'activité et donne le requestCode (variable private).
		startActivityForResult(photoPickerIntent, _RESULTAT_IMAGE_GALLERIE);

	}

	/**
	 * Methode pour aller vers la gallerie photo
	 * 
	 * @author Francis Marion
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// Si le requestCode est le bon, il rentre dans la boucle de la photo
		// existante.
		if (requestCode == _RESULTAT_IMAGE_GALLERIE) {

			// Trouver le path de l'image selectionné.
			Uri photoLocation = data.getData();

			try {
				// L'ouvre en stream de data/bytes.
				InputStream openInputStream = getContentResolver()
						.openInputStream(photoLocation);

				// Prend le Stream et le converti en Bitmap.
				Bitmap imageExistante = BitmapFactory
						.decodeStream(openInputStream);

				// Regle le probleme de la grosseur de l'image.
				imageExistante = Bitmap.createScaledBitmap(imageExistante,
						width, height, true);

				// Assigne l'image à la vue.
				imageSelectionner.setImageBitmap(imageExistante);

				addToDB(imageExistante, mEdit.getText().toString());

			} catch (FileNotFoundException e) {
				e.printStackTrace();

				// Reponse s'il y a une erreur.
				Toast.makeText(this, "N'est pas capable d'ouvrir la photo.",
						Toast.LENGTH_LONG).show();

			}

		}

		// Si le requestCode est le bon, il rentre dans la boucle de la photo
		// existante.
		else if (requestCode == _RESULTAT_IMAGE_NOUVELLE) {

			// Prend le Stream et le converti en Bitmap.
			Bitmap ImageNouvelle = (Bitmap) data.getExtras().get("data");

			// Regle le probleme de la grosseur de l'image.
			ImageNouvelle = Bitmap.createScaledBitmap(ImageNouvelle, width,
					height, true);

			// Commence l'activité et donne le requestCode (variable private).
			imageSelectionner.setImageBitmap(ImageNouvelle);

			addToDB(ImageNouvelle, "");
		}

	}

	/**
	 * Methode pour créer une nouvelle photo à partir de l'appareil photo.
	 * 
	 * @author Francis Marion
	 */
	public void onClickImageNouvelle(View v) {

		// On veut créer une nouvelle photo à partir de l'appareil photo et
		// l'intent est un ACTION_IMAGE_CAPTURE.
		Intent cameraIntent = new Intent(
				android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

		// Commence l'activité et donne le requestCode (variable private).
		startActivityForResult(cameraIntent, _RESULTAT_IMAGE_NOUVELLE);
	}

	private void addToDB(Bitmap image, String titre) {

		Photo photo;

		photo = new Photo(titre, image);
		MainActivity.jdb.JournaldeBord.add(photo);
	}

}