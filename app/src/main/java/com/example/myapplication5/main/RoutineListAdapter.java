package com.example.myapplication5.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Routine.Routine;
import com.example.myapplication5.main.database.EasyProgram1DbHandler;

import java.util.ArrayList;

public class RoutineListAdapter extends RecyclerView.Adapter<RoutineListAdapter.RoutineListViewHolder> {

    public ArrayList<Routine> routineList;

    int completed=0;
    public RoutineListAdapter(ArrayList<Routine> exerciseList){
        this.routineList=exerciseList;
        System.out.println(this.routineList.size());
    }



    @NonNull
    @Override
    public RoutineListAdapter.RoutineListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_routine_layout, null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        lp.bottomMargin=4;
        layoutView.setLayoutParams(lp);

        RoutineListViewHolder rcv = new RoutineListViewHolder(layoutView);
        return rcv;
    }

    public ArrayList<Routine>  getRoutineList(){
        return  routineList;
    }

    @Override
    public void onBindViewHolder(@NonNull final RoutineListAdapter.RoutineListViewHolder holder, int position) {
        int com=0;
        for(Exercise r: routineList.get(holder.getAdapterPosition()).getExercisesList()){
            if (r.getComplete()){
                com++;
            }
        }



        if(com==routineList.get(holder.getAdapterPosition()).getExercisesList().size()){
            holder.mComplete.setImageResource(R.drawable.checked);
            holder.mComplete.setBackground(null);
            routineList.get(holder.getAdapterPosition()).setComplete(true);


        }
        holder.mName.setText("Day "+(position+1));
       // holder.mImage.setImageResource(routineList.get(holder.getAdapterPosition()).getThumbnail());

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RoutineActivity.class);
                Bundle args = new Bundle();
                ArrayList<String> names =new ArrayList<>();
                ArrayList<String> type = new ArrayList<>();
                ArrayList<String> programs= new ArrayList<>();
                ArrayList<Integer> routines= new ArrayList<>();
                ArrayList<Integer> complete= new ArrayList<>();
                int i=0;
                int[] reps = new int[routineList.get(holder.getAdapterPosition()).getExercisesList().size()];
                String[] desc1 = new String[routineList.get(holder.getAdapterPosition()).getExercisesList().size()];
                String[] desc2 = new String[routineList.get(holder.getAdapterPosition()).getExercisesList().size()];
                for(Exercise r: routineList.get(holder.getAdapterPosition()).getExercisesList()){

                    names.add(r.getName());
                    type.add(r.getType());
                    reps[i]=r.getReps();
                    desc1[i]=r.getDescription()[0];
                    desc2[i]=r.getDescription()[1];
                    programs.add(r.getProgram());
                    if(r.getComplete()){
                        complete.add(1);
                    }
                    else {
                        complete.add(0);
                    }

                    routines.add(r.getRoutine());
                    i++;
                }
                args.putStringArrayList("names",names);
                args.putStringArrayList("type",type);
                args.putIntArray("reps",reps);
                args.putStringArray("desc1",desc1);
                args.putStringArray("desc2",desc2);
                args.putStringArrayList("programs",programs);
                args.putIntegerArrayList("routines",routines);
                args.putIntegerArrayList("complete",complete);
                intent.putExtra("exerciseName",routineList.get(holder.getAdapterPosition()).getName());
                intent.putExtra("exerciseImages",routineList.get(holder.getAdapterPosition()).getThumbnail());
                //args.putStringArray("desc", routineList.get(holder.getAdapterPosition()).);
                //args.putParcelableArrayList("ExerciseList",routineList.get(holder.getAdapterPosition()).getExercisesList());

                //intent.putExtra("exercisesList",routineList.get(holder.getAdapterPosition()).getExercisesList());
                intent.putExtra("List",args);
                //Exercise exercise = exerciseList.get(holder.getAdapterPosition())
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return routineList.size();
    }

    public class RoutineListViewHolder  extends RecyclerView.ViewHolder{

        public TextView mName;
        public ConstraintLayout mLayout;
       // public ImageView mImage;
        public ImageView mComplete;
        public ProgressBar mProgress;

        public RoutineListViewHolder(@NonNull View view) {
            super(view);
            mName = view.findViewById(R.id.program_list_item_name);
           // mImage =view.findViewById(R.id.program_list_item_image);
            mLayout =view.findViewById(R.id.program_list_item_layout);
            mComplete= view.findViewById(R.id.program_list_item_complete);
            mProgress = view.findViewById(R.id.pBar);

            //mProgress.setProgress(0);
        }
    }
}
