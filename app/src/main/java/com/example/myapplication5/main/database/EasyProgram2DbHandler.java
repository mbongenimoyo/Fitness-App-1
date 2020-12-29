package com.example.myapplication5.main.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EasyProgram2DbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME="fitnessApp.db";

    private static final String TABLE_NAME="easyprogram2";

    private static final String COLUMN_ID="id";

    private static final String COLUMN_PROGRAM="program";

    private static final String COLUMN_NAME="name";

    private static final String COLUMN_TYPE="type";

    private static final String COLUMN_REPS="reps";

    private static final String DESC1="desc1";

    private static final String DESC2 ="desc2";

    private static final String COLUMN_COMPLETE="complete" ;
    private static final String COLUMN_ROUTINE = "routine";

    SQLiteDatabase database;
    public EasyProgram2DbHandler(@Nullable Context context) {

        super(context,
                DATABASE_NAME,
                null,
                DATABASE_VERSION);
        database= getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE "+ TABLE_NAME+" ( "+COLUMN_ID+ " INTEGER PRIMARY KEY, "+COLUMN_PROGRAM +" TEXT, "+ COLUMN_ROUTINE +" INTEGER, "+ COLUMN_NAME +" TEXT, "+ COLUMN_TYPE +" TEXT, "+ COLUMN_REPS +" INTEGER, "+ DESC1 +" TEXT, "+ DESC2 +" TEXT ,"+ COLUMN_COMPLETE +" BOOLEAN) ");





    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insertExercise(String name, String type, String program,int routine, int reps, String desc1,String desc2, Boolean complete){

        SQLiteDatabase db=  this.getWritableDatabase();
        ContentValues contentValues = new  ContentValues();
        contentValues.put(COLUMN_NAME, "planks");
        contentValues.put(COLUMN_PROGRAM, "Easy_program_2");
        contentValues.put(COLUMN_TYPE, "seconds");
        contentValues.put(COLUMN_ROUTINE, 1);
        contentValues.put(COLUMN_REPS, "10");
        contentValues.put(DESC1, "planks description 1");
        contentValues.put(DESC2, "planks description 2");
        contentValues.put(COLUMN_COMPLETE, false);
        db.insert(TABLE_NAME,null,contentValues);
        return false;
    }

//    private boolean checkDataBase() {
//        SQLiteDatabase checkDB = null;
//        try {
//            checkDB = SQLiteDatabase.openDatabase(, null,
//                    SQLiteDatabase.OPEN_READONLY);
//            checkDB.close();
//        } catch (SQLiteException e) {
//            // database doesn't exist yet.
//        }
//        return checkDB != null;
//    }

    public void initialiseEasyProgram1() {
        SQLiteDatabase db = this.getWritableDatabase();
        int r = 10;
        int s=20;
        for (int i = 1; i < 30; i++) {

            if (i % 5 != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "planks");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_2");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, s);
                contentValues.put(DESC1, "planks description 1");
                contentValues.put(DESC2, "planks description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME, null, contentValues);

                contentValues.put(COLUMN_NAME, "crunches");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_1");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME, null, contentValues);

                contentValues.put(COLUMN_NAME, "twisting crunches");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_1");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "twisting crunches description 1");
                contentValues.put(DESC2, "twisting crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME, null, contentValues);

                contentValues.put(COLUMN_NAME, "sit ups");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_1");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME, null, contentValues);
                r = r + 5;
                s=s+5;

            } else {

                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "rest");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_1");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i + 1);
                contentValues.put(COLUMN_REPS, 0);
                contentValues.put(DESC1, "rest day");
                contentValues.put(DESC2, "");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME, null, contentValues);
                r = r - 10;
                s=s-10;
            }
        }
    }




}

