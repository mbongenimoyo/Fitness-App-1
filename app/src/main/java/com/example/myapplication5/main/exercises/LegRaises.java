package com.example.myapplication5.main.exercises;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Exercise;

public class LegRaises implements Exercise {

    public LegRaises(int reps,String type){
        this.reps=reps;
        this.type=type;
    };
    public LegRaises(){

    }

    public String program;
    public Integer routine;

    public String name="Leg raises";

    public String type;

    public int reps;
    public String[] description = new String[]
            {" Lay down with your hands to your sides for support then Raise your legs so they are off the ground, keeping the abdominals tight.",
                    "Slowly raise your legs 90 degrees, contracting the abdominal muscles.Slowly return to starting position. Do not touch the floor with your feet"
            };


    Boolean complete=false;

    public int[] images=new int[]{
            R.drawable.legraises,
            R.drawable.legraises
    };
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String[] getDescription() {
        return this.description;
    }

    @Override
    public int[] getImages() {
        return this.images;
    }

    @Override
    public int getReps() {
        return reps;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setComplete(Boolean b) {
        complete=b;
    }

    @Override
    public Boolean getComplete() {
        return complete;
    }

    @Override
    public Integer getRoutine() {
        return routine;
    }

    @Override
    public String getProgram() {
        return program;
    }

}
