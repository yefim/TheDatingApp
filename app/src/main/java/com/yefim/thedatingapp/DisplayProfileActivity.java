package com.yefim.thedatingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);

        Intent intent = getIntent();

        if (intent.hasExtra(MainActivity.EXTRA_MESSAGE)) {
            String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            TextView distanceText = (TextView) findViewById(R.id.distanceText);
            distanceText.setText(message);
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, MessageUserActivity.class);
        startActivity(intent);
    }
}
