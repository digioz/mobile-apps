package com.digioz.yamba;

import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StatusActivity extends Activity implements OnClickListener {
	EditText editStatus;
	Button buttonUpdate;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status);
        
        editStatus = (EditText) findViewById(R.id.editStatus);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        
        buttonUpdate.setOnClickListener(this);
    }

	public void onClick(View v) {
		Log.d("StatusActivity","Clicked on update button and entered method.");
		
		String status = editStatus.getText().toString();
		
		new PostToTwitter().execute(status);
		
		Log.d("StatusActivity","Finished executing click event with status: "+status);
	}
	
	private class PostToTwitter extends AsyncTask<String, String, String> {

		@Override
		protected String doInBackground(String... status) {
			String result;
			
			// Update status online
			try {
				Twitter twitter = new Twitter("student", "password");
				twitter.setAPIRootUrl("http://yamba.marakana.com/api");
				twitter.setStatus(status[0]);
				
				result = StatusActivity.this.getString(R.string.msgStatusUpdatedSuccessfully);
			} catch (TwitterException e) {
				e.printStackTrace();
				result = StatusActivity.this.getString(R.string.msgStatusUpdateFailed);
			}
			
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			
			Toast.makeText(StatusActivity.this, result, Toast.LENGTH_LONG).show();
		}	
	}
}