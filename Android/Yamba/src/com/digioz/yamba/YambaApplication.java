package com.digioz.yamba;

import winterwell.jtwitter.Twitter;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;

public class YambaApplication extends Application implements OnSharedPreferenceChangeListener{
	SharedPreferences prefs;
	private Twitter twitter;
	StatusData statusData;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		prefs.registerOnSharedPreferenceChangeListener(this);
		
		statusData = new StatusData(this);
	}
	
	/**
	 * Lazily initializes the 
	 * connection to the online service
	 * @return Twitter object representing 
	 * connection to online service
	 */
	public synchronized Twitter getTwitter() {
		if (twitter == null) {
			String username = prefs.getString("username", "");
			String password = prefs.getString("password","");
			String server = prefs.getString("server", "");
			twitter = new Twitter(username, password);
			twitter.setAPIRootUrl(server);
		}
		return twitter;
	}

	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		// Invalidate twitter
		twitter = null;
	}
}
