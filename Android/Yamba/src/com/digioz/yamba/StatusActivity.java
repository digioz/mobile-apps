package com.digioz.yamba;

import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.TwitterException;
import android.app.Activity;
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
		String status = editStatus.getText().toString();
		
		// Update status online
		try {
			Twitter twitter = new Twitter("student", "password");
			twitter.setAPIRootUrl("http://yamba.marakana.com/api");
			twitter.setStatus(status);
			editStatus.setText("");
			Toast.makeText(this, R.string.msgStatusUpdatedSuccessfully, Toast.LENGTH_LONG).show();
		} catch (TwitterException e) {
			e.printStackTrace();
			Toast.makeText(this, R.string.msgStatusUpdateFailed, Toast.LENGTH_LONG).show();
		}
		
		Log.d("StatusActivity","onClick'd with status: "+status);
		
	}
}