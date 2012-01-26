package com.digioz.yamba;

import java.util.List;

import winterwell.jtwitter.Twitter.Status;
import android.app.Service;
import android.content.Intent;
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
		YambaApplication yamba;
		
		public Updater() {
			super("Updater");
			yamba = ((YambaApplication)getApplication());
		}
		
		@Override
		public void run() {
			isRunning = true;
			
			while (isRunning) {
				try {
					Log.d(TAG, "Updater running");
					
					List<Status> statuses = yamba.getTwitter().getFriendsTimeline();
					
					for(Status status: statuses) {
						// Insert data
						yamba.statusData.insert(status);
						
						Log.d(TAG, String.format("%s: %s", status.user.name, status.text));
					}
					
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
