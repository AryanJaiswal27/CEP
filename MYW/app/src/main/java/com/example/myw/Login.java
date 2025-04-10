package com.example.myw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText  email, passwordEditText;
    Button logButton;

    TextView register;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();


        register = findViewById(R.id.log_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i  = new Intent(Login.this , Register.class);
                startActivity(i);
                finish();
            }

        });





        email = findViewById(R.id.log_email);
        passwordEditText = findViewById(R.id.log_pass);

        logButton = findViewById(R.id.log_login);


        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString().trim();
                String password = passwordEditText.getText().toString();


                 if (mail.isEmpty() || (!mail.endsWith("@gmail.com")) || mail.length()<=10) {


                    Toast.makeText(Login.this, "Please enter your email", Toast.LENGTH_SHORT).show();

                }

                else if (password.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your password", Toast.LENGTH_SHORT).show();

                }

                else if (password.length() < 8) {
                    Toast.makeText(Login.this, "Password must be atleast 8 characters", Toast.LENGTH_SHORT).show();

                }
                else{


                    mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent i  = new Intent(Login.this , Home.class);
                                startActivity(i);
                                finish();


                            } else {
                                Toast.makeText(Login.this, "Login Failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });












                }


            }

        });

    }
}