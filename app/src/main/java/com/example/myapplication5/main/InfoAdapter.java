package com.example.myapplication5.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication5.R;
import com.example.myapplication5.main.info.Info;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {


    ArrayList<Info> infoArrayList = new ArrayList<>();


    public InfoAdapter(ArrayList<Info> infoArrayList) {
        this.infoArrayList = infoArrayList;
    }

    @NonNull
    @Override
    public InfoAdapter.InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info, null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.bottomMargin=2;
        layoutView.setLayoutParams(lp);
        InfoViewHolder rcv = new InfoViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.InfoViewHolder holder, int position) {
        holder.mHeader.setText(infoArrayList.get(position).getHeader());
        holder.mParagraph.setText(infoArrayList.get(position).getParagraph());



    }

    @Override
    public int getItemCount() {
        return infoArrayList.size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder {
        TextView mHeader;
        TextView mParagraph;

        public InfoViewHolder(@NonNull View itemView) {

            super(itemView);
            mHeader =itemView.findViewById(R.id.info_header);
            mParagraph = itemView.findViewById(R.id.info_paragraph);
        }
    }
}
