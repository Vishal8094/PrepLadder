package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondYear extends AppCompatActivity {
    Button cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_year);

        cn=findViewById(R.id.cn);
        cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotourl("https://firebasestorage.googleapis.com/v0/b/prepladder-6c79f.appspot.com/o/DOC-20230103-WA0007..pdf?alt=media&token=a19a5ae1-6e43-4aa3-8e10-fd9281c9b87a");
            }
        });
    }

    private void gotourl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}