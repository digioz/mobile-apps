package com.digioz.yamba;

import winterwell.jtwitter.Twitter.Status;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class StatusData {
	private static final String TAG = StatusData.class.getSimpleName();
	
	public static final String C_ID = BaseColumns._ID; // Special for id
	public static final String C_CREATED_AT = "yamba_createdAt";
	public static final String C_USER = "yamba_user";
	public static final String C_TEXT = "yamba_text";
	
	Context context;
	DbHelper dbHelper;
	
	public StatusData(Context context) {
		this.context = context;
		dbHelper = new DbHelper(context);
	}
	
	/**
	 * Inserts into database
	 * @param values Name/value pairs data
	 */
	public void insert(ContentValues values) {
		// Open Database
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		// Insert into database
		db.insertWithOnConflict(DbHelper.TABLE, null, values, SQLiteDatabase.CONFLICT_IGNORE);
		
		// Close Database
		db.close();
		//dbHelper.close();
	}
	
	/**
	 * Inserts into database
	 * @param status Status data as provided by online service
	 */
	public void insert(Status status)
	{
		ContentValues values = new ContentValues();
		values.put(StatusData.C_ID, status.id);
		values.put(StatusData.C_CREATED_AT, status.createdAt.getTime());
		values.put(StatusData.C_USER, status.user.name);
		values.put(StatusData.C_TEXT, status.text);
		this.insert(values);
	}
	
	public void delete() {
		// Open Database
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		
		// Delete the data
		db.delete(DbHelper.TABLE, null, null);
		
		// Close Database
		db.close();
	}
	
	/**
	 * Class to help open/create/upgrade database
	 * @author Pedram
	 */
	private class DbHelper extends SQLiteOpenHelper {
		public static final String DB_NAME = "timeline.db";
		public static final int DB_VERSION = 1;
		public static final String TABLE = "statuses";

		public DbHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			String sql = String.format("create table %s (%s INT primary key, %s INT, %s TEXT, %s TEXT)", TABLE, C_ID, C_CREATED_AT, C_USER, C_TEXT); 
			
			Log.d(TAG, "onCreate sql: " + sql);
			db.execSQL(sql);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// Typically you do ALTER TABLE here
			db.execSQL("drop table if exists " + TABLE);
			Log.d(TAG,"onUpgrade dropped table " + TABLE);
			this.onCreate(db);
		}
	}
}
