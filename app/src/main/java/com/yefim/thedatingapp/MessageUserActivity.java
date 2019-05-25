package com.yefim.thedatingapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MessageUserActivity extends AppCompatActivity {
    private ChatAdapter mChatAdapter;
    private RecyclerView mRecyclerView;
    private EditText editText;
    private LinearLayoutManager mLayoutManager;
    private TextView typingIndicatorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_user);

        typingIndicatorText = (TextView) findViewById(R.id.typingIndicatorText);
        typingIndicatorText.setVisibility(View.INVISIBLE);

        editText = (EditText) findViewById(R.id.messageText);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mChatAdapter = new ChatAdapter();
        mRecyclerView.setAdapter(mChatAdapter);
    }

    public void sendMessage(View view) {
        this.mChatAdapter.appendMessage(new Message("me", editText.getText().toString()));
        editText.getText().clear();

        // show wanda is typing...
        final Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                typingIndicatorText.setVisibility(View.VISIBLE);
            }
        }, 5000);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // clear wanda is typing...
                typingIndicatorText.setVisibility(View.INVISIBLE);
                autoMessage();
            }
        }, Math.max(600, 10000 - 200 * this.mChatAdapter.size()));
    }

    private void autoMessage() {
        if (this.mChatAdapter.size() == 1) {
            this.mChatAdapter.appendMessage(new Message("Wanda", "Hahaha everyone needs a cup of Joe in their life! Just taking a walk :)"));
        } else if (this.mChatAdapter.size() == 3) {
            this.mChatAdapter.appendMessage(new Message("Wanda", "Well, I love paintings. What about you?"));
        } else if (this.mChatAdapter.size() == 5) {
            this.mChatAdapter.appendMessage(new Message("Wanda", "I’ve recently gotten into postmodernism!"));
        }
    }
}
