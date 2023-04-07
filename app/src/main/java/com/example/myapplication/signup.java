package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    TextView logedin;
    ImageView start;
    EditText email,password,confirm_password;
    String emailpattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;



    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        confirm_password=findViewById(R.id.confirm_password);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


      start=findViewById(R.id.start);
      start.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            
              PerformAuth();
          }
      });
      
      


        logedin=findViewById(R.id.logedin);
        logedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void PerformAuth() {
        String emailid=email.getText().toString();
        String pass=password.getText().toString();
        String confpass=confirm_password.getText().toString();
        if(!emailid.matches(emailpattern))
        {
            email.setError("Enter a Valid Email");
        }
        else if(pass.isEmpty() || pass.length()<6)
        {
            password.setError("Enter a strong Password");
        }
        else if(!pass.equals(confpass))
        {
            confirm_password.setError("Password Don't Match");
        }
        else
        {
           progressDialog.setMessage("Please wait while we set for you");
           progressDialog.setTitle("Registration");
           progressDialog.setCanceledOnTouchOutside(false);
           progressDialog.show();

           mAuth.createUserWithEmailAndPassword(emailid,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful())
                   {
                       progressDialog.dismiss();
                       sendtologin();
                       Toast.makeText(signup.this, "You got Registered", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       progressDialog.dismiss();
                       Toast.makeText(signup.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                   }

               }
           });
        }

    }

    private void sendtologin() {
        Intent intent=new Intent(signup.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}