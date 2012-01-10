package com.digioz.yamba;

import java.util.List;

import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.Twitter.Status;
import android.app.Service;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.util.Log;

public class UpdaterService extends Service {
	private static final String TAG = UpdaterService.class.getSimpleName();
	private Updater updater;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		updater = new Updater();
		
		Log.d(TAG, "onCreate fired");
	}
	
	@Override
	public synchronized void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		
		if (!updater.isRunning) {
			updater.start();		
		}
		
		Log.d(TAG, "onStart fired");
	}
	
	@Override
	public synchronized void onDestroy() {
		super.onDestroy();
		
		if (updater.isRunning)
		{
			updater.interrupt();
		}
		
		updater = null;
		
		Log.d(TAG, "onDestroy fired");
	}
	
	class Updater extends Thread {
		static final long DELAY = 60000;
		public boolean isRunning = false;
		
		public Updater() {
			super("Updater");
		}
		
		@Override
		public void run() {
			isRunning = true;
			
			while (isRunning) {
				try {
					Log.d(TAG, "Updater running");
					
					// Open Database
					DbHelper dbHelper = new DbHelper(UpdaterService.this);
					SQLiteDatabase db = dbHelper.getWritableDatabase();
					
					Twitter twitter = ((YambaApplication)getApplication()).getTwitter();
					List<Status> statuses = twitter.getFriendsTimeline();
					ContentValues values = new ContentValues();
					
					for(Status status: statuses) {
						values.put(DbHelper.C_ID, status.id);
						values.put(DbHelper.C_CREATED_AT, status.createdAt.getTime());
						values.put(DbHelper.C_USER, status.user.name);
						values.put(DbHelper.C_TEXT, status.text);
						
						// Insert into database
						//db.insert(DbHelper.TABLE, null, values);
						db.insertWithOnConflict(DbHelper.TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);
						
						Log.d(TAG, String.format("%s: %s", status.user.name, status.text));
					}
					
					db.close();
					dbHelper.close();
					
					Thread.sleep(DELAY);
				} catch (InterruptedException e) {
					isRunning = false;
				}
			}
		}
		
		public boolean isRunning() {
			return this.isRunning;
		}	
	}
}
