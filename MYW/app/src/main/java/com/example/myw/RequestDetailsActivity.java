package com.example.saathi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RequestDetailsActivity extends AppCompatActivity {

    TextView titleText, categoryText, statusText, descriptionText;
    ImageView screenshotImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_request_details);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        titleText = findViewById(R.id.titleText);
        categoryText = findViewById(R.id.categoryText);
        statusText = findViewById(R.id.statusText);
        descriptionText = findViewById(R.id.descriptionText);
        screenshotImage = findViewById(R.id.screenshotImage);

        // Receive data from Intent
        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("title");
            String category = intent.getStringExtra("category");
            String status = intent.getStringExtra("status");
            String description = intent.getStringExtra("description");

            // Set values to views
            titleText.setText(title);
            categoryText.setText(category);
            statusText.setText(status);
            descriptionText.setText(description);
        }

        // Optional: Add image loading later if screenshot URL is passed
    }
}
