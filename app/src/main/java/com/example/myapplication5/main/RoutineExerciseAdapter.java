package com.example.myapplication5.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication5.MainActivity;
import com.example.myapplication5.R;
import com.example.myapplication5.main.database.EasyProgram1DbHandler;
import com.example.myapplication5.ui.main.MainFragment;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;

public class RoutineExerciseAdapter extends RecyclerView.Adapter<RoutineExerciseAdapter.RoutineExerciseViewHolder> {

    InterstitialAd mInterstitialAd;

    public ArrayList<Exercise> exerciseList;

    EasyProgram1DbHandler db;
    Context c;
    public RoutineExerciseAdapter(ArrayList<Exercise> exerciseList, Context context){
        this.exerciseList=exerciseList;
        System.out.println(this.exerciseList.size());
        c=context;
        this.db= new EasyProgram1DbHandler(context);
        MobileAds.initialize(context,
                "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }



    @NonNull
    @Override
    public RoutineExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_routine_exercise_layout, null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.bottomMargin=4;
        layoutView.setLayoutParams(lp);

        RoutineExerciseViewHolder rcv = new RoutineExerciseViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull final RoutineExerciseViewHolder holder, final int position) {
        if(exerciseList.get(position).getComplete()){
            holder.mComplete.setImageResource(R.drawable.checked);

        }
        if(exerciseList.get(position).getName()=="Rest"){
            holder.mName.setText(exerciseList.get(position).getName());
        }else{
            holder.mName.setText(exerciseList.get(position).getReps() +" "+exerciseList.get(position).getType()+" of "+exerciseList.get(position).getName());

        }

        //holder.mComplete.setImageResource(exerciseList.get(holder.getAdapterPosition()).getImages()[0]);
        //holder.mView.setImageResource(exerciseList.get(holder.getAdapterPosition()).getImages()[0]);

        holder.mComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exerciseList.get(holder.getAdapterPosition()).setComplete(true);
                holder.mComplete.setImageResource(R.drawable.checked);
                holder.mComplete.setBackground(null);
                exerciseList.get(position).setComplete(true);
                db.setExerciseComplete(exerciseList.get(position).getName(),exerciseList.get(position).getProgram(),exerciseList.get(position).getRoutine());

                checkIfRoutineComplete(exerciseList, v);

            }
        });
        holder.mView.setOnClickListener(new View.OnClickListener() {
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

    private void checkIfRoutineComplete(ArrayList<Exercise> exerciseList, final View v) {
        int done = 0;
        for (Exercise e : exerciseList) {
            if (e.getComplete()) {
                done++;
            }
        }
        if (done == exerciseList.size()) {
            final Intent intent = new Intent(v.getContext(), MainActivity.class);
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                mInterstitialAd.setAdListener(new AdListener() {


                    @Override
                    public void onAdClosed() {
                        // Code to be executed when the interstitial ad is closed.
                        v.getContext().startActivity(intent);
                        ((Activity)v.getContext()).finish();
                    }
                });


            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
                v.getContext().startActivity(intent);
                ((Activity)v.getContext()).finish();
            }




        }

    }







    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

    public class RoutineExerciseViewHolder extends RecyclerView.ViewHolder{
        public TextView mName;
        public ConstraintLayout mLayout;
        public ImageView mComplete;
        public ImageView mView;
        public RoutineExerciseViewHolder(@NonNull View view) {
            super(view);
            mName = view.findViewById(R.id.routine_list_item_name);
            mLayout = view.findViewById(R.id.routine_item_layout);
            mComplete = view.findViewById(R.id.complete_button);
            mView = view.findViewById(R.id.view);
        }
    }


}
