package com.example.myapplication5.main.Programs;

import android.content.Context;
import android.database.Cursor;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Routine.Easy_1;
import com.example.myapplication5.main.Routine.Routine;
import com.example.myapplication5.main.database.EasyProgram1DbHandler;

import java.util.ArrayList;

public class Hard_program_1 implements Program {


    public ArrayList<Routine> routines= new ArrayList<>();

    public String name="Advanced program 1";
    int thumbnail= R.drawable.hard1;

    public String TABLE_NAME="hardprogram1";

    Context c;
    public Hard_program_1(){

    }

    public Hard_program_1(Context context){
        EasyProgram1DbHandler e = new EasyProgram1DbHandler(context);
        c=context;
        //e.getRoutines();
//        int size=e.countRoutines();
//        for(int i=1;i<=size;i++){
//            Cursor cur=e.getRoutine(i,TABLE_NAME);
//            ArrayList<String> exercises= new ArrayList<>();
//            ArrayList<Integer> reps = new ArrayList<>();
//            ArrayList<String> types= new ArrayList<>();
//            ArrayList<Integer> complete= new ArrayList<>();
//
//            String program="";
//            while(cur.moveToNext()){
//                exercises.add(cur.getString(3));
//                reps.add(cur.getInt(5));
//                types.add(cur.getString(4));
//                program=cur.getString(1);
//                complete.add(cur.getInt(8));
//
//
//            }
//            routines.add(new Easy_1(exercises,reps,types,program,complete,i));
//
//            //routines.add()
//        }
//        routines.add(new Easy_1(10,20));
//        routines.add(new Easy_1(15,25));
//        routines.add(new Easy_1(25,30));
//        routines.add(new Easy_1(30,35));
//        routines.add(new Rest());//Rest
//
//        routines.add(new Easy_1(10,20));
//        routines.add(new Easy_1(15,25));
//        routines.add(new Easy_1(25,30));
//        routines.add(new Easy_1(30,35));
//        routines.add(new Rest());//Rest
//
//        //================================================
//
//        routines.add(new Easy_1(15,25));
//        routines.add(new Easy_1(20,30));
//        routines.add(new Easy_1(25,35));
//        routines.add(new Easy_1(30,35));
//        routines.add(new Rest());//Rest
//
//        routines.add(new Easy_1(15,25));
//        routines.add(new Easy_1(20,30));
//        routines.add(new Easy_1(25,35));
//        routines.add(new Easy_1(30,35));
//        routines.add(new Rest());//Rest
//       // ==================================================
//
//        routines.add(new Easy_1(20,30));
//        routines.add(new Easy_1(25,35));
//        routines.add(new Easy_1(30,40));
//        routines.add(new Easy_1(35,45));
//        routines.add(new Rest());//Rest
//
//        routines.add(new Easy_1(25,35));
//        routines.add(new Easy_1(30,40));
//        routines.add(new Easy_1(35,45));
//        routines.add(new Easy_1(40,50));

        //============================================
    }

    @Override
    public ArrayList<Routine> getRoutines() {
        //Easy_program_1 db = new Easy_program_1();
        EasyProgram1DbHandler e = new EasyProgram1DbHandler(c);

        //e.getRoutines();
        int size=e.countRoutines();
        for(int i=1;i<=size;i++){
            Cursor cur=e.getRoutine(i,TABLE_NAME);
            ArrayList<String> exercises= new ArrayList<>();
            ArrayList<Integer> reps = new ArrayList<>();
            ArrayList<String> types= new ArrayList<>();
            ArrayList<Integer> complete= new ArrayList<>();

            String program="";
            while(cur.moveToNext()){
                exercises.add(cur.getString(3));
                reps.add(cur.getInt(5));
                types.add(cur.getString(4));
                program=cur.getString(1);
                complete.add(cur.getInt(8));


            }
            routines.add(new Easy_1(exercises,reps,types,program,complete,i));

            //routines.add()
        }
        return  routines;
    }

    @Override
    public int getThumbnail() {
        return thumbnail;
    }

    @Override
    public String getName() {
        return name;
    }


}
