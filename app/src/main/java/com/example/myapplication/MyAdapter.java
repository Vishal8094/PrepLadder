package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<bookstalls> bookDetails;

    public MyAdapter(Context context,ArrayList<bookstalls> bookDetails){
        this.context = context;
        this.bookDetails = bookDetails;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.books_row,parent,false);
        MyViewHolder viewholder = new MyViewHolder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bookNameTextView.setText(bookDetails.get(position).bookName);

    }

    @Override
    public int getItemCount() {
        return bookDetails.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView bookNameTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bookNameTextView=itemView.findViewById(R.id.names);
        }
    }




}

