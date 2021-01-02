package com.example.myapplication5.main.exercises;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Exercise;

public class RestDay implements Exercise {

    Boolean complete=false;
    public RestDay(Integer reps, String type){

        this.reps=reps;
        this.type=type;
    }

    public String program;
    public Integer routine;

    public String name="Rest";



    public String[] description = new String[]
            {" his one is for beginners. Sit on a mat with your legs extended and toes pointed. Squeeze your abs, and lean back placing forearms on the mat",
                    "Lift your right arm overhead and twist your torso to the left while leaving your left forearm on the mat. Return to center and switch arms"
            };

    public int reps;


    public String type="";

    public RestDay(Integer reps, String type, Integer complete,String program,Integer routine) {
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
        return name;
    }

    @Override
    public String[] getDescription() {
        return description;
    }

    public int[] images=new int[]{
            R.drawable.plank,
            R.drawable.plank
    };

    @Override
    public int[] getImages() {
        return images;
    }

    @Override
    public int getReps() {
        return 0;
    }

    @Override
    public String getType() {
        return "Rest";
    }

    @Override
    public void setComplete(Boolean b) {
        this.complete=b;
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
