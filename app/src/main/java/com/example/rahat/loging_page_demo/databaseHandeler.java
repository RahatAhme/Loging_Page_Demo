package com.example.rahat.loging_page_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Rahat on 3/20/2018.
 */

public class databaseHandeler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserDetails.db";
    private static final String TABLE_NAME = "User_table";
    private static final String ID = "_id";
    private static final String NAME = "Name";
    private static final String USER_ID = "User_ID";
    private static final String EMAIL = "Email";
    private static final String PASSWORD = "Password";
    private static final int Version = 3;
    Context context;


    private static final String CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME+" ( "+ ID+" INTEGER PRIMARY KEY AUTO INCREMENT, "+ NAME+" VARCHAR(50) NOT NULL, "+ USER_ID + " VARCHAR(50) NOT NULL, "+ EMAIL + " VARCHAR(50) NOT NULL, "+PASSWORD +" VARCHAR(50) NOT NULL ); " ;

    private static final  String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;

    public databaseHandeler(Context context) {

        super(context, DATABASE_NAME, null, Version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
            onCreate(sqLiteDatabase);
            Toast.makeText(context, "Create complete", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context, "Exception is : "+ e, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            Toast.makeText(context, "we are in ON_UPGRADE", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }catch (Exception e){
            Toast.makeText(context, "Exception is : 0"+ e, Toast.LENGTH_SHORT).show();
        }
    }
}
