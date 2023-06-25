package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class page3 extends AppCompatActivity {

    CardView firstYear,secondYear,thirdYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        firstYear = findViewById(R.id.firstYear);
        firstYear.setOnClickListener(v -> {
            Intent intent = new Intent(page3.this,FirstYear.class);
            startActivity(intent);
        });

        secondYear = findViewById(R.id.secondYear);
        secondYear.setOnClickListener(v -> {
            Intent intent = new Intent(page3.this,SecondYear.class);
            startActivity(intent);
        });

        thirdYear = findViewById(R.id.thirdYear);
        thirdYear.setOnClickListener(v -> {
            Intent intent = new Intent(page3.this, ThirdYear.class);
            page3.this.startActivity(intent);
        });
    }

}