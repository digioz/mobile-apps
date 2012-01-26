package com.digioz.yamba;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TimelineActivity extends Activity {
	private static final String TAG = TimelineActivity.class.getSimpleName();
	TextView textStatuses;
	YambaApplication yamba;
	Cursor cursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		yamba = (YambaApplication)getApplication();
		
		// Setup UI
		setContentView(R.layout.timeline);
		textStatuses = (TextView)findViewById(R.id.textStatuses);
		
		// Get the data
		cursor = yamba.statusData.query();
		startManagingCursor(cursor);
		
		final int userColumnIndex = cursor.getColumnIndex(StatusData.C_USER);
		final int textColumnIndex = cursor.getColumnIndex(StatusData.C_TEXT);
		
		Log.d(TAG, "Got cursor with records: " + cursor.getCount());
		
		// Output it
		String user, text;
		
		while (cursor.moveToNext()) {
			user = cursor.getString(userColumnIndex);
			text = cursor.getString(textColumnIndex);
			textStatuses.append(String.format("\n%s: %s", user, text));
			Log.d(TAG, String.format("\n%s: %s", user, text));
		}
	}

}
