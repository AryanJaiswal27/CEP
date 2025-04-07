package com.example.myw;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = findViewById(R.id.issue_list);



        List<Issue> issueList = new ArrayList<>();

        issueList.add(new Issue(
                "Crash on Startup", "99090", "High", "Alice", "Open", "120", "5",
                "The app crashes immediately upon launching on Android 12 devices."
        ));

        issueList.add(new Issue(
                "UI Elements Misaligned", "99091", "Low", "Bob", "Resolved", "30", "2",
                "Layout breaks on smaller screen devices."
        ));

        issueList.add(new Issue(
                "Login Delay", "99092", "Medium", "Carlos", "Open", "60", "7",
                "It takes too long to log in with Google authentication."
        ));

        issueList.add(new Issue(
                "Missing Error Messages", "99093", "Medium", "Dana", "In Progress", "25", "1",
                "Form validation errors are not being shown to the user."
        ));

        issueList.add(new Issue(
                "Theme Not Switching", "99094", "Low", "Elena", "Closed", "15", "0",
                "Switching between light and dark theme doesn't reflect immediately."
        ));

        issueList.add(new Issue(
                "Search Not Filtering", "99095", "High", "Frank", "Open", "90", "12",
                "Search bar does not filter results as expected."
        ));

        issueList.add(new Issue(
                "App Freezes on Scroll", "99096", "Medium", "Grace", "In Review", "55", "3",
                "Scrolling through a long list causes occasional freezing."
        ));

        issueList.add(new Issue(
                "Incorrect Profile Image", "99097", "Low", "Hank", "Resolved", "12", "1",
                "Profile pictures appear pixelated after upload."
        ));

        issueList.add(new Issue(
                "Push Notifications Delayed", "99098", "High", "Ivy", "Open", "110", "6",
                "Notifications take several minutes to arrive."
        ));

        issueList.add(new Issue(
                "Data Sync Issues", "99099", "Medium", "Jack", "In Progress", "48", "4",
                "User data does not sync correctly between sessions."
        ));





        IssueAdapter adapter = new IssueAdapter(this, issueList);
        listView.setAdapter(adapter);

//
//
//        <activity
//        android:name=".Home"
//        android:exported="false" />
//                <activity
//        android:name=".OTP"
//        android:exported="false" />
//                <activity
//        android:name=".Verify"
//        android:exported="false" />
//                <activity
//        android:name=".Login"
//        android:exported="false" />
//                <activity
//        android:name=".Register"
//        android:exported="false" />
    }
}