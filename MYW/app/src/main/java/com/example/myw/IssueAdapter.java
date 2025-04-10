package com.example.myw;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Objects;

public class IssueAdapter extends ArrayAdapter<Issue> {

    public IssueAdapter(Context context, List<Issue> issues) {
        super(context, 0, issues);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Issue issue = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.issue, parent, false);
        }

        TextView titleView = convertView.findViewById(R.id.issue_title);
        TextView id = convertView.findViewById(R.id.issue_id);
        TextView severityView = convertView.findViewById(R.id.issue_severity);
        TextView authorView = convertView.findViewById(R.id.issue_author);
        TextView statusView = convertView.findViewById(R.id.issue_status);
        TextView upvote = convertView.findViewById(R.id.issue_upvote);
        TextView downvote = convertView.findViewById(R.id.issue_downvote);
        TextView descriptionView = convertView.findViewById(R.id.issue_desc);

        titleView.setText(Objects.requireNonNull(issue).getTitle());
        id.setText(String.format("Id: #%s", issue.getKey()));
        severityView.setText(String.format("Severity: %s", issue.getSeverity()));
        authorView.setText(String.format("Author: %s", issue.getAuthor()));
        statusView.setText(String.format("Status: %s", issue.getStatus()));
        upvote.setText(issue.getUpvote() );
        downvote.setText( issue.getDownvote());
        descriptionView.setText(issue.getDescription());

        String severity = issue.getSeverity().toLowerCase();
        switch (severity) {
            case "high":
                convertView.setBackgroundResource(R.drawable.red); // light red
                break;
            case "medium":
                convertView.setBackgroundResource(R.drawable.orange); // light yellow
                break;
            case "low":
                convertView.setBackgroundResource(R.drawable.yellow); // light green
                break;
            default:
                convertView.setBackgroundColor(Color.WHITE); // default
                break;
        }


        upvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        downvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return convertView;
    }
}
