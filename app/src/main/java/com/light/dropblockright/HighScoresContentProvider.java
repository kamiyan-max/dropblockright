package com.light.dropblockright;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

public class HighScoresContentProvider extends ContentProvider {

    private HighScoresDbHelper dbHelper;

  
    private static final String AUTHORITY = "com.light.dropblockright.contentprovider";

    
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/highscores");

   
    @Override
    public boolean onCreate() {
       
        dbHelper = new HighScoresDbHelper(getContext());
        return false;
    }

   
    @Override
    public String getType(Uri uri) {
        return null;
    }

    
    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = db.insert(HighScoresDb.SQLITE_TABLE, null, values);
        getContext().getContentResolver().notifyChange(uri, null);
        return Uri.parse(CONTENT_URI + "/" + id);
    }

   
    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(HighScoresDb.SQLITE_TABLE);

        Cursor cursor = queryBuilder.query(db, projection, selection,
                selectionArgs, null, null, sortOrder);
        return cursor;

    }

  
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        return 0;
    }

  
    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return 0;
    }

}

