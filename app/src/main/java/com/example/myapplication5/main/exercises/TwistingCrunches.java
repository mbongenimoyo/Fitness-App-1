package com.example.myapplication5.main.exercises;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Exercise;

public class TwistingCrunches implements Exercise {

    public String name="Twisting crunches";

    public String program;
    public Integer routine;

    public String[] description = new String[]
            {"Lay flat on the floor with your feet flat on the ground and knees at a 90 degree angle.Place your hands behind your head or across your chest. Beginners should place them across the chest",
                    "Curl your torso towards your knees, lifting the shoulder blades off the ground. When curling up, twist so that one elbow is pointing at your knees.Hold the curled position and contract the abdominal muscles for 2 seconds.Repeat to the other side."
            };
    public String type;

    public int reps;

    public int[] images=new int[]{
            R.drawable.twisting_crunches,
            R.drawable.twisting_crunches
    };
    public TwistingCrunches(int reps, String type){
        this.type=type;
        this.reps=reps;
    };
    Boolean complete=false;

    public TwistingCrunches(Integer reps, String type, Integer complete,String program,Integer routine) {
        this.reps=reps;
        this.type=type;
        this.program=program;
        this.routine=routine;
        if(complete==1){
            this.complete=true;
        }
    }

    public TwistingCrunches() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String[] getDescription() {
        return this.description;
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
