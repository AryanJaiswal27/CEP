package com.example.myw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText  emailEditText, passwordEditText;
    Button logButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        emailEditText = findViewById(R.id.log_email);
        passwordEditText = findViewById(R.id.log_pass);

        logButton = findViewById(R.id.log_login);


        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();


                 if (email.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your email", Toast.LENGTH_SHORT).show();

                }

                else if (password.isEmpty()) {
                    Toast.makeText(Login.this, "Please enter your password", Toast.LENGTH_SHORT).show();

                }

                else if (password.length() < 8) {
                    Toast.makeText(Login.this, "Password must be atleast 8 characters", Toast.LENGTH_SHORT).show();

                }
                else{


                    Toast.makeText(Login.this, "Logging In...", Toast.LENGTH_SHORT).show();

                }


            }

        });

    }
}