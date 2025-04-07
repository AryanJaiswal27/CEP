package com.example.myw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText nameEditText, emailEditText, passwordEditText;
    Button  registerButton;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        nameEditText = findViewById(R.id.reg_name);
        emailEditText = findViewById(R.id.reg_email);
        passwordEditText = findViewById(R.id.reg_pass);

        registerButton = findViewById(R.id.reg_register);
        auth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(Register.this, "Please enter your name", Toast.LENGTH_SHORT).show();

                }

                else if (email.isEmpty()) {
                    Toast.makeText(Register.this, "Please enter your email", Toast.LENGTH_SHORT).show();

                }

                else if (password.isEmpty()) {
                    Toast.makeText(Register.this, "Please enter your password", Toast.LENGTH_SHORT).show();

                }

                else if (password.length() < 8) {
                    Toast.makeText(Register.this, "Password must be atleast 8 characters", Toast.LENGTH_SHORT).show();

                }
                else{


                Toast.makeText(Register.this, "Registering...", Toast.LENGTH_SHORT).show();

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Register.this,new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isComplete()){

                            Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(Register.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

                }


            }

        });



    }
}