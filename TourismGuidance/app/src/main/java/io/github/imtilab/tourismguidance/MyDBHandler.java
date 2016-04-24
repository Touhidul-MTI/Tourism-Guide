package io.github.imtilab.tourismguidance;

/**
 * Created by Touhidul_MTI on 04-Apr-16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Touhidul_MTI on 04-Mar-16.
 */
public class MyDBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "TourismDatabase.db";
    private static final String TABLE_NAME = "ImageTable";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_IMAGE = "imageName";

    Context context;

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryToCreateTable = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_IMAGE + " blob)";

        db.execSQL(queryToCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //add/insert data/person
    public long addSpot(byte[]image) {
        SQLiteDatabase sqldb = getWritableDatabase();

        try {

            ContentValues values = new ContentValues();
            values.put(COLUMN_IMAGE, image);

            long longNumber = sqldb.insert(TABLE_NAME, null, values);
            sqldb.close();

            return longNumber;
        }catch (Exception e){

        }

        return -2;
    }

    public Cursor getDatabaseCursorForAllData(){

        SQLiteDatabase sqldb = getWritableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        //cursor point to a location in result
        Cursor cursor = sqldb.rawQuery(query, null);

        cursor.moveToFirst();

        return cursor;

//        if (cursor.moveToFirst()){
//            byte[] imgByte = cursor.getBlob(0);
//            cursor.close();
//            return BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
//        }
//        if (cursor != null && !cursor.isClosed()) {
//            cursor.close();
//        }

//        return null ;
    }

}
