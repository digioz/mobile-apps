package com.digioz.yamba;

import winterwell.jtwitter.TwitterException;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StatusActivity extends Activity implements OnClickListener {
	EditText editStatus;
	Button buttonUpdate;
	ProgressDialog postingDialog;
	static final int DIALOG_ID = 47;
	YambaApplication yamba;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		yamba = (YambaApplication)getApplication();
		setContentView(R.layout.status);

		editStatus = (EditText) findViewById(R.id.editStatus);
		buttonUpdate = (Button) findViewById(R.id.buttonUpdate);

		buttonUpdate.setOnClickListener(this);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DIALOG_ID: {
			ProgressDialog dialog = new ProgressDialog(this);
			dialog.setMessage(StatusActivity.this.getString(R.string.msgPleaseWaitWhilePosting));
			dialog.setIndeterminate(true);
			dialog.setCancelable(true);
			return dialog;
		}
		}

		// return super.onCreateDialog(id);
		return null;
	}

	public void onClick(View v) {
		Log.d("StatusActivity", "Clicked on update button and entered method.");

		String status = editStatus.getText().toString();

		showDialog(DIALOG_ID);

		new PostToTwitter().execute(status);

		Log.d("StatusActivity", "Finished executing click event with status: "
				+ status);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.itemPrefs:
			startActivity(new Intent(this, PrefsActivity.class));
			break;
		case R.id.itemServiceStart:
			startService(new Intent(this, UpdaterService.class));
			break;
		case R.id.itemServiceStop:
			stopService(new Intent(this, UpdaterService.class));
			break;
		case R.id.itemPurge:
			yamba.statusData.delete();
			Toast.makeText(this, R.string.msgAllDataPurged, Toast.LENGTH_LONG).show();
			break;
		}

		return true;
	}

	private class PostToTwitter extends AsyncTask<String, String, String> {

		@Override
		protected String doInBackground(String... status) {
			String result;

			// Update status online
			try {
				YambaApplication app = ((YambaApplication) getApplication());
				app.getTwitter().setStatus(status[0]);

				result = StatusActivity.this
						.getString(R.string.msgStatusUpdatedSuccessfully);
			} catch (TwitterException e) {
				e.printStackTrace();
				result = StatusActivity.this
						.getString(R.string.msgStatusUpdateFailed);
			}

			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			dismissDialog(DIALOG_ID);
			Toast.makeText(StatusActivity.this, result, Toast.LENGTH_LONG)
					.show();
		}
	}
}