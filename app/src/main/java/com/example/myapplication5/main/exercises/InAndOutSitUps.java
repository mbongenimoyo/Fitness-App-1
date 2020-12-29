package com.example.myapplication5.main.exercises;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Exercise;

public class InAndOutSitUps implements Exercise {

    public  InAndOutSitUps(int reps,String type){
        this.reps = reps;

        this.type = type;
    };
    public Integer routine;
    public String program;

    public InAndOutSitUps(){

    }


    Boolean complete=false;

    public String type;

    public int reps;
    public String name="In and out sit ups";


    public String[] description = new String[]
            {" Lie flat on your mat with knees bent and feet on the mat. Hands at the base of your head and elbows pointed out.",
                    "Using your abdominals bring your head and shoulders off the mat and come up into a crunch, then lower with control"
            };


    public int[] images=new int[]{
            R.drawable.in_and_out_sit_ups,
            R.drawable.in_and_out_sit_ups
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
