package com.example.myapplication;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class SecondYear extends AppCompatActivity {
    ArrayList<bookstalls> bookDetails = new ArrayList<>();
    String[] bookNames = {"Computer Networks","Data Structures & Algorithm-2",
                          "Operational Research","Computational Geometry",
                          "Wireless Communication & Internet Of Things","Embedded System Design",
                          "English","Environmental Science"};
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_year);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        RecyclerView recyclerView= findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        while(position<bookNames.length) {
            bookDetails.add(new bookstalls(bookNames[position]));
            position++;
        }

        MyAdapter adapter = new MyAdapter(this,bookDetails);
        recyclerView.setAdapter(adapter);
    }



}