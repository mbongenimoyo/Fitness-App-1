package com.example.myapplication5.main.exercises;

import android.annotation.SuppressLint;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Exercise;

@SuppressLint("ParcelCreator")
public class BalletTwists implements Exercise {


    Boolean complete=false;
    public BalletTwists(){

    }

    public BalletTwists( int reps,String type){
        this.reps=reps;
        this.type=type;
    }
    public String name="Ballet twist";

    public Integer routine;
    public String program;



    public String[] description = new String[]
            {" his one is for beginners. Sit on a mat with your legs extended and toes pointed. Squeeze your abs, and lean back placing forearms on the mat",
                    "Lift your right arm overhead and twist your torso to the left while leaving your left forearm on the mat. Return to center and switch arms"
            };

    public int reps;

    public String type;

    public int[] images=new int[]{
            R.drawable.basic_crunch_exercise_part1,
            R.drawable.basic_crunch_exercise_part2
    };
    @Override
    public String getName() {
        return null;
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
