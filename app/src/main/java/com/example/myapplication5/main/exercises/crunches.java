package com.example.myapplication5.main.exercises;

import android.annotation.SuppressLint;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Exercise;
import com.example.myapplication5.ui.main.Models.ExerciseType;

@SuppressLint("ParcelCreator")
public class crunches implements Exercise {

    Boolean complete=false;



    public crunches(Integer reps,String type){
        this.reps=reps;
        this.type=type;
    }

    public  crunches(Integer reps, Integer integer){

        this.reps=reps;
        this.type=type;
    }
    public String name="Crunches";

    public String type;

    public int reps;

    public String[] description = new String[]
            {" Lie flat on your mat with knees bent and feet on the mat. Hands at the base of your head and elbows pointed out.",
             "Using your abdominals bring your head and shoulders off the mat and come up into a crunch, then lower with control"
            };


    public int[] images=new int[]{
            R.drawable.crunches,
            R.drawable.crunches
    };

    public crunches(int reps){
        this.reps=reps;
    }

    public ExerciseType exerciseType= ExerciseType.REPS;

    public String program;
    public Integer routine;

    public crunches(Integer reps, String type, Integer complete,String program,Integer routine) {
        this.reps=reps;
        this.type=type;
        this.program=program;
        this.routine=routine;
        if(complete==1){
            this.complete=true;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String[] getDescription() {
        return description;
    }

    @Override
    public int[] getImages() {
        return images;
    }

    @Override
    public int getReps() {
        return reps;
    }



    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setComplete(Boolean b) {
        complete=b;
    }

    @Override
    public Integer getRoutine() {
        return routine;
    }

    @Override
    public String getProgram() {
        return program;
    }

    @Override
    public Boolean getComplete() {
        return complete;
    }

}
