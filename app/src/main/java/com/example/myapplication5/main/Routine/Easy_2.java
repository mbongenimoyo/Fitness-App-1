package com.example.myapplication5.main.Routine;

import com.example.myapplication5.main.Exercise;
import com.example.myapplication5.main.exercises.Planks;
import com.example.myapplication5.main.exercises.SitUp;
import com.example.myapplication5.main.exercises.TwistingCrunches;
import com.example.myapplication5.main.exercises.crunches;

import java.util.ArrayList;

public class Easy_2 implements Routine {
    ArrayList<Exercise> exercisesList = new ArrayList<>();
    Boolean[] checks= new Boolean[]{false,false,false,false};

    String name;
    int reps=10;
    int timedreps =15;

    int thumbnail;
    Boolean[] com=new Boolean[]{false};

    public Easy_2(){
        exercisesList.add(new crunches(reps,"reps"));
        exercisesList.add( new SitUp(reps,"reps"));
        exercisesList.add(new TwistingCrunches(reps,"reps"));
        exercisesList.add(new Planks(timedreps,"timed"));
    }
    @Override
    public ArrayList<Exercise> getExercisesList (){
        return exercisesList;
    }

    @Override
    public Boolean[] getCheckComplete() {
        return checks;
    }

    @Override
    public int getThumbnail() {
        return thumbnail;
    }

    @Override
    public void setComplete(Boolean e) {
        this.checks[0] = e;
    }

    @Override
    public String getName() {
        return null;
    }
}
