package com.example.android.displaylibrary.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import com.example.android.displaylibrary.R;

public class DisplayActivity extends AppCompatActivity {

    private static final String JOKE_EXTRA_KEY = "joke";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_display);

        TextView textView = findViewById(R.id.text_view);
        String joke = getIntent().getStringExtra(JOKE_EXTRA_KEY);
        textView.setText(joke);
    }
}
