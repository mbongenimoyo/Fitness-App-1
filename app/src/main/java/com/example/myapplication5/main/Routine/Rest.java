package com.example.myapplication5.main.Routine;

import com.example.myapplication5.main.Exercise;
import com.example.myapplication5.main.exercises.RestDay;
import com.example.myapplication5.main.exercises.crunches;

import java.util.ArrayList;

public class Rest implements Routine {

    String name;
    int reps=10;
    int timedreps =15;


    ArrayList<Exercise> exercisesList = new ArrayList<>();
    Boolean[] checks= new Boolean[]{false,false,false,false};

    public Rest(){
        exercisesList.add(new RestDay(0,""));
    }

    @Override
    public ArrayList<Exercise> getExercisesList() {

        return exercisesList;
    }

    @Override
    public Boolean[] getCheckComplete() {
        return checks;
    }

    @Override
    public int getThumbnail() {
        return 0;
    }

    @Override
    public void setComplete(Boolean e) {
        this.checks[0]=e;
    }

    @Override
    public String getName() {
        return name;
    }
}
