package com.example.myapplication5.main;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication5.R;
import com.example.myapplication5.main.Programs.Program;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ProgramViewHolder> {

    ArrayList<Program> programs ;
    public ProgramAdapter(ArrayList<Program> programList) {
        programs = programList;
    }

    @NonNull
    @Override
    public ProgramAdapter.ProgramViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.program_item, null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.bottomMargin=4;
        layoutView.setLayoutParams(lp);

        ProgramViewHolder rcv = new ProgramViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProgramAdapter.ProgramViewHolder holder, int position) {
        holder.mName.setText(programs.get(position).getName());

//        Picasso.with(holder.itemView.getContext())
//                .load(programs.get(position).getThumbnail())
//                //.placeholder(programs.get(position).getThumbnail())
//                .into(holder.mImage);
        holder.mImage.setImageResource(programs.get(position).getThumbnail());

        holder.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ProgramActivity.class);
                intent.putExtra("programName",programs.get(holder.getAdapterPosition()).getName());
//                intent.putExtra("exerciseImages",exerciseList.get(holder.getAdapterPosition()).getImages());
//                intent.putExtra("exerciseDesc",exerciseList.get(holder.getAdapterPosition()).getDescription());
                //Exercise exercise = exerciseList.get(holder.getAdapterPosition())
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return programs.size();
    }

    public class ProgramViewHolder  extends RecyclerView.ViewHolder{

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        TextView mName;
        ImageView mImage;
        RelativeLayout mLayout;


        public ProgramViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.program_list_item_name);
            mImage = itemView.findViewById(R.id.background_img);
            mLayout = itemView.findViewById(R.id.program_item_layout);

        }
    }
}
