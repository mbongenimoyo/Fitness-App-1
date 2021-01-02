package com.example.myapplication5.main.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication5.main.ExerciseListActivity;
import com.example.myapplication5.main.Routine.Routine;
import com.example.myapplication5.ui.main.MainFragment;

import java.util.ArrayList;

public class EasyProgram1DbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;

    private static final String DATABASE_NAME="fitnessApp.db";

    private static final String TABLE_NAME="easyprogram1";

    private static final String TABLE_NAME2="easyprogram2";

    private static final String TABLE_NAME3="mediumprogram1";

    private static final String TABLE_NAME4="mediumprogram2";

    private static final String TABLE_NAME5="hardprogram1";

    private static final String TABLE_NAME6="hardprogram2";

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
    public EasyProgram1DbHandler(@Nullable Context context) {

        super(context,
                DATABASE_NAME,
                null,
                DATABASE_VERSION);
        database= getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("CREATE TABLE "+ TABLE_NAME+" ( "+COLUMN_ID+ " INTEGER PRIMARY KEY, "+COLUMN_PROGRAM +" TEXT, "+ COLUMN_ROUTINE +" INTEGER, "+ COLUMN_NAME +" TEXT, "+ COLUMN_TYPE +" TEXT, "+ COLUMN_REPS +" INTEGER, "+ DESC1 +" TEXT, "+ DESC2 +" TEXT ,"+ COLUMN_COMPLETE +" BOOLEAN) ");
        db.execSQL("CREATE TABLE "+ TABLE_NAME2+" ( "+COLUMN_ID+ " INTEGER PRIMARY KEY, "+COLUMN_PROGRAM +" TEXT, "+ COLUMN_ROUTINE +" INTEGER, "+ COLUMN_NAME +" TEXT, "+ COLUMN_TYPE +" TEXT, "+ COLUMN_REPS +" INTEGER, "+ DESC1 +" TEXT, "+ DESC2 +" TEXT ,"+ COLUMN_COMPLETE +" BOOLEAN) ");
        db.execSQL("CREATE TABLE "+ TABLE_NAME3+" ( "+COLUMN_ID+ " INTEGER PRIMARY KEY, "+COLUMN_PROGRAM +" TEXT, "+ COLUMN_ROUTINE +" INTEGER, "+ COLUMN_NAME +" TEXT, "+ COLUMN_TYPE +" TEXT, "+ COLUMN_REPS +" INTEGER, "+ DESC1 +" TEXT, "+ DESC2 +" TEXT ,"+ COLUMN_COMPLETE +" BOOLEAN) ");
        db.execSQL("CREATE TABLE "+ TABLE_NAME4+" ( "+COLUMN_ID+ " INTEGER PRIMARY KEY, "+COLUMN_PROGRAM +" TEXT, "+ COLUMN_ROUTINE +" INTEGER, "+ COLUMN_NAME +" TEXT, "+ COLUMN_TYPE +" TEXT, "+ COLUMN_REPS +" INTEGER, "+ DESC1 +" TEXT, "+ DESC2 +" TEXT ,"+ COLUMN_COMPLETE +" BOOLEAN) ");
        db.execSQL("CREATE TABLE "+ TABLE_NAME5+" ( "+COLUMN_ID+ " INTEGER PRIMARY KEY, "+COLUMN_PROGRAM +" TEXT, "+ COLUMN_ROUTINE +" INTEGER, "+ COLUMN_NAME +" TEXT, "+ COLUMN_TYPE +" TEXT, "+ COLUMN_REPS +" INTEGER, "+ DESC1 +" TEXT, "+ DESC2 +" TEXT ,"+ COLUMN_COMPLETE +" BOOLEAN) ");
        db.execSQL("CREATE TABLE "+ TABLE_NAME6+" ( "+COLUMN_ID+ " INTEGER PRIMARY KEY, "+COLUMN_PROGRAM +" TEXT, "+ COLUMN_ROUTINE +" INTEGER, "+ COLUMN_NAME +" TEXT, "+ COLUMN_TYPE +" TEXT, "+ COLUMN_REPS +" INTEGER, "+ DESC1 +" TEXT, "+ DESC2 +" TEXT ,"+ COLUMN_COMPLETE +" BOOLEAN) ");

        initialiseEasyProgram1(db);
        initialiseEasyProgram2(db);
        initialiseMedProgram1(db);
        initialiseMedProgram2(db);
        initialiseHardProgram1(db);
        initialiseHardProgram2(db);





    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insertExercise(String name, String type, String program,int routine, int reps, String desc1,String desc2, Boolean complete){

        SQLiteDatabase db=  this.getWritableDatabase();
        ContentValues contentValues = new  ContentValues();
        contentValues.put(COLUMN_NAME, "planks");
        contentValues.put(COLUMN_PROGRAM, "Easy_program_1");
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

    public void initialiseEasyProgram1(SQLiteDatabase db) {
        int r = 5;
        int s=15;
        for (int i = 1; i <=30; i++) {

            if (i % 5 != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "planks");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_1");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
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
                contentValues.put(COLUMN_ROUTINE, i );
                contentValues.put(COLUMN_REPS, 0);
                contentValues.put(DESC1, "rest day");
                contentValues.put(DESC2, "");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME, null, contentValues);
                r = r - 10;
            }
        }
    }

    public void initialiseEasyProgram2(SQLiteDatabase db) {

        int r = 10;
        int s=15;
        for (int i = 1; i <= 30; i++) {

            if (i % 5 != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "planks");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_2");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "planks description 1");
                contentValues.put(DESC2, "planks description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME2, null, contentValues);

                contentValues.put(COLUMN_NAME, "crunches");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_2");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME2, null, contentValues);

                contentValues.put(COLUMN_NAME, "twisting crunches");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_2");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "twisting crunches description 1");
                contentValues.put(DESC2, "twisting crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME2, null, contentValues);

                contentValues.put(COLUMN_NAME, "sit ups");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_2");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME2, null, contentValues);
                r = r + 5;
                s=s+5;

            } else {

                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "rest");
                contentValues.put(COLUMN_PROGRAM, "Easy_program_2");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i );
                contentValues.put(COLUMN_REPS, 0);
                contentValues.put(DESC1, "rest day");
                contentValues.put(DESC2, "");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME2, null, contentValues);
                r = r -5;
            }
        }
    }

    public Cursor getRoutines(){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur =db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return cur;

    }

    public int countRoutines(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur =db.rawQuery("SELECT COUNT( DISTINCT "+COLUMN_ROUTINE+" ) FROM "+TABLE_NAME,null);
        int count=0;
        while(cur.moveToNext()){
            count=cur.getInt(0);
        }
        return count;
    }

    public Cursor getRoutine(int day,String table){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur =db.rawQuery("SELECT * FROM "+table+" WHERE routine ="+day,null);
        return cur;

    }

    public void setExerciseComplete(String name, String program, Integer routine){

        SQLiteDatabase db = this.getWritableDatabase();

        String table="";
        if(program.equals("Easy_program_1")){
            table="easyprogram1";
        }
        else if(program.equals("Easy_program_2")){
            table="easyprogram2";
        }
        else if(program.equals("Medium_program_1")){
            table="mediumprogram1";
        }
        else if(program.equals("Medium_program_2")){
            table="mediumprogram2";
        }
        else if(program.equals("Hard_program_1")){
            table="hardprogram1";
        }
        else if(program.equals("Hard_program_2")){
            table="hardprogram2";
        }
//        ContentValues cv = new ContentValues();
//        cv.put(COLUMN_COMPLETE,1);
//        db.update(TABLE_NAME, COLUMN_COMPLETE+" =")

        String query=("UPDATE "+table+" SET "+COLUMN_COMPLETE+" = 1 WHERE "+ COLUMN_NAME+" = '"+name.toLowerCase()+"' AND "+ COLUMN_ROUTINE +" = "+ routine);
        db.execSQL(query);
       System.out.println( query);

    }


    public void initialiseMedProgram1(SQLiteDatabase db) {

        int r = 25;
        int s=35;
        for (int i = 1; i <=30; i++) {

            if (i % 5 != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "planks");
                contentValues.put(COLUMN_PROGRAM, "Medium_program_1");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "planks description 1");
                contentValues.put(DESC2, "planks description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME3, null, contentValues);

                contentValues.put(COLUMN_NAME, "crunches");
                contentValues.put(COLUMN_PROGRAM, "Medium_program_1");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME3, null, contentValues);

                contentValues.put(COLUMN_NAME, "twisting crunches");
                contentValues.put(COLUMN_PROGRAM, "Medium_program_1");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "twisting crunches description 1");
                contentValues.put(DESC2, "twisting crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME3, null, contentValues);

                contentValues.put(COLUMN_NAME, "sit ups");
                contentValues.put(COLUMN_PROGRAM, "Medium_program_1");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME3, null, contentValues);
                r = r + 5;
                s=s+5;

            } else {

                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "rest");
                contentValues.put(COLUMN_PROGRAM, "Medium_program_1");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i );
                contentValues.put(COLUMN_REPS, 0);
                contentValues.put(DESC1, "rest day");
                contentValues.put(DESC2, "");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME3, null, contentValues);
                r = r -5;
            }
        }
    }
    public void initialiseMedProgram2(SQLiteDatabase db) {

        int r = 25;
        int s=35;
        for (int i = 1; i <=30; i++) {

            if (i % 5 != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "planks");
                contentValues.put(COLUMN_PROGRAM, "Medium_program_2");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "planks description 1");
                contentValues.put(DESC2, "planks description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME4, null, contentValues);

                contentValues.put(COLUMN_NAME, "crunches");
                contentValues.put(COLUMN_PROGRAM, "Medium_program_2");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME4, null, contentValues);

                contentValues.put(COLUMN_NAME, "twisting crunches");
                contentValues.put(COLUMN_PROGRAM, "Medium_program_2");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "twisting crunches description 1");
                contentValues.put(DESC2, "twisting crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME4, null, contentValues);

                contentValues.put(COLUMN_NAME, "sit ups");
                contentValues.put(COLUMN_PROGRAM, "Medium_program_2");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME4, null, contentValues);
                r = r + 5;
                s=s+5;

            } else {

                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "rest");
                contentValues.put(COLUMN_PROGRAM, "Medium_program_2");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i );
                contentValues.put(COLUMN_REPS, 0);
                contentValues.put(DESC1, "rest day");
                contentValues.put(DESC2, "");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME4, null, contentValues);
                r = r -5;

            }
        }
    }

    public void initialiseHardProgram1(SQLiteDatabase db) {
        int r = 30;
        int s=45;
        for (int i = 1; i <=30; i++) {

            if (i % 5 != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "planks");
                contentValues.put(COLUMN_PROGRAM, "Hard_program_1");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "planks description 1");
                contentValues.put(DESC2, "planks description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME5, null, contentValues);

                contentValues.put(COLUMN_NAME, "crunches");
                contentValues.put(COLUMN_PROGRAM, "Hard_program_1");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME5, null, contentValues);

                contentValues.put(COLUMN_NAME, "twisting crunches");
                contentValues.put(COLUMN_PROGRAM, "Hard_program_1");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "twisting crunches description 1");
                contentValues.put(DESC2, "twisting crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME5, null, contentValues);

                contentValues.put(COLUMN_NAME, "sit ups");
                contentValues.put(COLUMN_PROGRAM, "Hard_program_1");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME5, null, contentValues);
                r = r + 5;
                s=s+5;

            } else {

                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "rest");
                contentValues.put(COLUMN_PROGRAM, "Hard_program_1");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i );
                contentValues.put(COLUMN_REPS, 0);
                contentValues.put(DESC1, "rest day");
                contentValues.put(DESC2, "");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME5, null, contentValues);
                r = r - 10;
            }
        }
    }

    public void initialiseHardProgram2(SQLiteDatabase db) {

        int r = 35;
        int s=50;
        for (int i = 1; i <= 30; i++) {

            if (i % 5 != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "planks");
                contentValues.put(COLUMN_PROGRAM, "Hard_program_2");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "planks description 1");
                contentValues.put(DESC2, "planks description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME6, null, contentValues);

                contentValues.put(COLUMN_NAME, "crunches");
                contentValues.put(COLUMN_PROGRAM, "Hard_program_2");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME6, null, contentValues);

                contentValues.put(COLUMN_NAME, "twisting crunches");
                contentValues.put(COLUMN_PROGRAM, "Hard_program_2");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "twisting crunches description 1");
                contentValues.put(DESC2, "twisting crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME6, null, contentValues);

                contentValues.put(COLUMN_NAME, "sit ups");
                contentValues.put(COLUMN_PROGRAM, "Hard_program_2");
                contentValues.put(COLUMN_TYPE, "reps");
                contentValues.put(COLUMN_ROUTINE, i);
                contentValues.put(COLUMN_REPS, r);
                contentValues.put(DESC1, "crunches description 1");
                contentValues.put(DESC2, "crunches description 2");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME6, null, contentValues);
                r = r + 5;
                s=s+5;

            } else {

                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_NAME, "rest");
                contentValues.put(COLUMN_PROGRAM, "Hard_program_2");
                contentValues.put(COLUMN_TYPE, "seconds");
                contentValues.put(COLUMN_ROUTINE, i );
                contentValues.put(COLUMN_REPS, 0);
                contentValues.put(DESC1, "rest day");
                contentValues.put(DESC2, "");
                contentValues.put(COLUMN_COMPLETE, false);
                db.insert(TABLE_NAME6, null, contentValues);
                r = r -5;
            }
        }
    }






}

