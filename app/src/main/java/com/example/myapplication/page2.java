package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


public class page2 extends AppCompatActivity {

    CardView books,notes,pyq,articles;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        books = findViewById(R.id.books);
        books.setOnClickListener(v -> {
            Intent intent = new Intent(page2.this,page3.class);
            startActivity(intent);
        });

        notes=findViewById(R.id.notes);
        notes.setOnClickListener(v -> {
            Intent intent=new Intent(page2.this,Notes.class);
            startActivity(intent);
        });


        articles = findViewById(R.id.articles);
        articles.setOnClickListener(v -> {
            Intent i = new Intent(page2.this,Articles.class);
            startActivity(i);
        });
        pyq = findViewById(R.id.pyq);
        pyq.setOnClickListener(v -> {
            Intent intent = new Intent(page2.this, pyq.class);
            startActivity(intent);
        });
    }
}