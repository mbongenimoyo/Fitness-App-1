package com.example.myapplication5.main.Routine;

import com.example.myapplication5.main.Exercise;

import java.util.ArrayList;
import java.util.List;

public interface Routine {

    public ArrayList<Exercise> getExercisesList ();

    public Boolean[] getCheckComplete();

    public int getThumbnail();

    public void setComplete(Boolean e);

    String getName();
}
