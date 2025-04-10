package com.example.myw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReviewComplaintActivity extends AppCompatActivity {

    private TextView tvReviewTitle, tvReviewDescription, tvReviewCategory, tvReviewSeverity, tvReviewLocation, tvReviewContact;
    private ViewPager2 viewPagerReviewImages;
    private RelativeLayout rlReviewImagePreview;
    private ImageButton btnReviewLeft, btnReviewRight;
    private Button btnEdit, btnSubmit;

    private ArrayList<Uri> reviewMediaUris = new ArrayList<>();
    private ImagePagerAdapter imagePagerAdapter; // Reusing the adapter from your project

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_complaint);

        // Initialize UI components
        tvReviewTitle = findViewById(R.id.tvReviewTitle);
        tvReviewDescription = findViewById(R.id.tvReviewDescription);
        tvReviewCategory = findViewById(R.id.tvReviewCategory);
        tvReviewSeverity = findViewById(R.id.tvReviewSeverity);
        tvReviewLocation = findViewById(R.id.tvReviewLocation);
        tvReviewContact = findViewById(R.id.tvReviewContact);

        rlReviewImagePreview = findViewById(R.id.rlReviewImagePreview);
        viewPagerReviewImages = findViewById(R.id.viewPagerReviewImages);
        btnReviewLeft = findViewById(R.id.btnReviewLeft);
        btnReviewRight = findViewById(R.id.btnReviewRight);
        btnEdit = findViewById(R.id.btnEdit);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Retrieve data passed from MainActivity
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String category = intent.getStringExtra("category");
        String severity = intent.getStringExtra("severity");
        String location = intent.getStringExtra("location");
        String contact = intent.getStringExtra("contact");
        ArrayList<String> mediaUriStrings = intent.getStringArrayListExtra("mediaUris");

        // Populate TextViews with complaint details
        tvReviewTitle.setText(title);
        tvReviewDescription.setText(description);
        tvReviewCategory.setText(category);
        tvReviewSeverity.setText(severity);
        tvReviewLocation.setText(location);
        tvReviewContact.setText(contact);

        // Process media URIs (if any)
        if (mediaUriStrings != null && !mediaUriStrings.isEmpty()) {
            for (String uriString : mediaUriStrings) {
                reviewMediaUris.add(Uri.parse(uriString));
            }
            // Set up ViewPager2 with media URIs
            imagePagerAdapter = new ImagePagerAdapter(reviewMediaUris);
            viewPagerReviewImages.setAdapter(imagePagerAdapter);
            rlReviewImagePreview.setVisibility(View.VISIBLE);
            if (reviewMediaUris.size() > 1) {
                btnReviewLeft.setVisibility(View.VISIBLE);
                btnReviewRight.setVisibility(View.VISIBLE);
            }
        } else {
            rlReviewImagePreview.setVisibility(View.GONE);
        }

        // Set up left arrow navigation
        btnReviewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentItem = viewPagerReviewImages.getCurrentItem();
                if (currentItem > 0) {
                    viewPagerReviewImages.setCurrentItem(currentItem - 1, true);
                }
            }
        });

        // Set up right arrow navigation
        btnReviewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentItem = viewPagerReviewImages.getCurrentItem();
                if (currentItem < reviewMediaUris.size() - 1) {
                    viewPagerReviewImages.setCurrentItem(currentItem + 1, true);
                }
            }
        });

        // Edit button: return to MainActivity for further edits
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Closes this activity so user can edit the details in MainActivity
            }
        });

        // Submit button: handle submission logic
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. (Optional) Validate or do submission logic
                // 2. Navigate to the success page
                Intent intent = new Intent(ReviewComplaintActivity.this, SubmissionSuccessActivity.class);

                // If you want to pass a custom complaint ID:
                //  e.g., intent.putExtra("complaintId", "#CMP-742834");

                startActivity(intent);
                finish();
            }
        });


    }
}