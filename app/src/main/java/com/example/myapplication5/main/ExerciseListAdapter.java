package com.example.myapplication5.main;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication5.R;


import java.util.ArrayList;


public class ExerciseListAdapter extends RecyclerView.Adapter<ExerciseListAdapter.ExerciseListViewHolder> {

    public ArrayList<Exercise> exerciseList;

   public ExerciseListAdapter(ArrayList<Exercise> exerciseList){
       this.exerciseList=exerciseList;
       System.out.println(this.exerciseList.size());
   }

    @NonNull
    @Override
    public ExerciseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise_layout, null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.bottomMargin=4;
        layoutView.setLayoutParams(lp);

        ExerciseListViewHolder rcv = new ExerciseListViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExerciseListViewHolder holder, int position) {
        holder.mName.setText(exerciseList.get(position).getName());
        holder.mImage.setImageResource(exerciseList.get(holder.getAdapterPosition()).getImages()[0]);

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ExercisePageActivity.class);
                intent.putExtra("exerciseName",exerciseList.get(holder.getAdapterPosition()).getName());
                intent.putExtra("exerciseImages",exerciseList.get(holder.getAdapterPosition()).getImages());
                intent.putExtra("exerciseDesc",exerciseList.get(holder.getAdapterPosition()).getDescription());
                //Exercise exercise = exerciseList.get(holder.getAdapterPosition())
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() { return exerciseList.size(); }


    class ExerciseListViewHolder extends RecyclerView.ViewHolder{

       public TextView mName;
       public LinearLayout mLayout;
       public ImageView mImage;


        public ExerciseListViewHolder(View view) {
            super(view);
            mName = view.findViewById(R.id.exercise_list_item_name);
            mLayout = view.findViewById(R.id.exerise_list_item_layout);
            mImage = view.findViewById(R.id.exercise_list_item_image);

        }


    }
}
