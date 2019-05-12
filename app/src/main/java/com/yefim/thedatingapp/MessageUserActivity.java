package com.yefim.thedatingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MessageUserActivity extends AppCompatActivity {
    private ChatAdapter mChatAdapter;
    private RecyclerView mRecyclerView;
    private EditText editText;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_user);

        editText = (EditText) findViewById(R.id.messageText);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mChatAdapter = new ChatAdapter();
        mRecyclerView.setAdapter(mChatAdapter);
    }

    public void sendMessage(View view) {
        mChatAdapter.appendMessage(new Message("me", editText.getText().toString()));
        editText.getText().clear();


    }

    private void autoMessage() {
        /*
        if (this.messages.size() == 1) {
            this.messages.add(new Message("Wanda", "Hahaha everyone needs a cup of Joe in their life! Just taking a walk :)"));
        } else if (this.messages.size() == 3) {
            this.messages.add(new Message("Wanda", "Well, I love paintings. What about you?"));
        } else if (this.messages.size() == 5) {
            this.messages.add(new Message("Wanda", "I’ve recently gotten into postmodernism!"));
        }
        */
    }
}
