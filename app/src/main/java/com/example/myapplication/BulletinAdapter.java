package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BulletinAdapter extends RecyclerView.Adapter<BulletinAdapter.BulletinViewHolder> {
    private ArrayList<BulletinInfo> arrayList;
    private Context context;

    public BulletinAdapter(ArrayList<BulletinInfo> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BulletinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        BulletinViewHolder holder = new BulletinViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BulletinViewHolder holder, int position) {
        holder.textViewPostContent.setText(arrayList.get(position).getContent());
        holder.textViewDate.setText(arrayList.get(position).getDate());
        holder.textViewNickname.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class BulletinViewHolder extends RecyclerView.ViewHolder {
        TextView textViewPostContent;
        TextView textViewDate;
        TextView textViewNickname;
        public BulletinViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewPostContent = itemView.findViewById(R.id.textViewPostContent);
            this.textViewDate = itemView.findViewById(R.id.textViewDate);
            this.textViewNickname = itemView.findViewById(R.id.textViewNickname);
        }
    }
}
