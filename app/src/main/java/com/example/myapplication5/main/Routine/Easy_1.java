package com.example.myapplication5.main.Routine;

import com.example.myapplication5.main.Exercise;
import com.example.myapplication5.main.exercises.Planks;
import com.example.myapplication5.main.exercises.RestDay;
import com.example.myapplication5.main.exercises.SitUp;
import com.example.myapplication5.main.exercises.TwistingCrunches;
import com.example.myapplication5.main.exercises.crunches;

import java.util.ArrayList;

public class Easy_1 implements Routine {
    ArrayList<Exercise> exercisesList = new ArrayList<>();
    Boolean[] checks= new Boolean[]{false,false,false,false};

    String name="";
    int reps=10;
    int timedreps =15;


    int thumbnail;


    public Easy_1( int reps,int timed){
        exercisesList.add(new crunches(reps,"reps"));
        exercisesList.add( new SitUp(reps,"reps"));
        exercisesList.add(new TwistingCrunches(reps,"reps"));
        exercisesList.add(new Planks(timed,"timed"));
    }

    public Easy_1( ArrayList<String> exercises,ArrayList<Integer> reps,ArrayList<String> types ,String program,ArrayList<Integer> complete,Integer routine){
        Integer count=0;
        for(String name: exercises){
            if(name.equals("crunches")){
                exercisesList.add(new crunches(reps.get(count),types.get(count),complete.get(count), program,routine));
            }
            else if(name.equals("planks")){
                exercisesList.add(new Planks(reps.get(count),types.get(count),complete.get(count), program,routine));
            }

            else if(name.equals("twisting crunches")){
                exercisesList.add(new TwistingCrunches(reps.get(count),types.get(count),complete.get(count), program,routine));
            }

            else if(name.equals("sit ups")){
                exercisesList.add(new SitUp(reps.get(count),types.get(count),complete.get(count), program,routine));
            }
            else if(name.equals("rest")){
                exercisesList.add(new RestDay(reps.get(count),types.get(count),complete.get(count), program,routine));
            }

            count++;
        }

        System.out.println("klskad");
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
        this.checks[0] =e;
    }

    @Override
    public String getName() {
        return name;
    }
}
