package com.example.myapplication5.main.exercises;

import android.annotation.SuppressLint;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Exercise;

@SuppressLint("ParcelCreator")
public class Bicycle implements Exercise {

    public String name="Bicycle";


    public String[] description = new String[]
            {"Lie down on your back. Bend your legs and place feet firmly on the ground to stabilise your lower body. Cross your hands to opposite shoulders over your chest or place them behind your ears, without pulling on your neck",
                    "Curl your upper body all the way up toward your knees. Exhale as you lift.Slowly, lower yourself down, returning to your starting point. Inhale as you lower"
            };
    public String type;

    public int reps;
    Boolean complete=false;
    public String program;
    public Integer routine;

    public Bicycle(int reps, String type){
        this.reps=reps;
        this.type=type;
    }


    public Bicycle(Integer reps, String type, Integer complete, String program, Integer routine) {
        this.reps=reps;
        this.type=type;
        this.program=program;
        this.routine=routine;
        if(complete==1){
            this.complete=true;
        }
    }

    public int[] images=new int[]{
            R.drawable.sit_ups,
            R.drawable.sit_ups
    };

    public Bicycle() {

    }

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
