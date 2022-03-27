package com.example.animalsforthebetter.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.animalsforthebetter.Util.Config;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper databaseHelper;

    // All Static variables
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = Config.DATABASE_NAME;

    // Constructor
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static synchronized DatabaseHelper getInstance(Context context){
        if(databaseHelper==null){
            databaseHelper = new DatabaseHelper(context);
        }
        return databaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create tables SQL execution
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + Config.TABLE_ANIMAL + "("
                + Config.COLUMN_ANIMAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Config.COLUMN_ANIMAL_NAME + " TEXT NOT NULL, "
                + Config.COLUMN_ANIMAL_TYPE + " TEXT NOT NULL, "
                + Config.COLUMN_ANIMAL_DURATION + " INTEGER NOT NULL UNIQUE "
                + ")";

        Logger.d("Table create SQL: " + CREATE_STUDENT_TABLE);

        db.execSQL(CREATE_STUDENT_TABLE);

        Logger.d("DB created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + Config.TABLE_ANIMAL);

        // Create tables again
        onCreate(db);
    }

}