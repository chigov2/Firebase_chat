package com.chigov.firebase_chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMessages;
    private MessagesAdapter adapter;
    private EditText editTextEnterMassage;
    private ImageView imageViewAddImage;
    private ImageView imageViewSendMessage;
    private List <Message> messages;
    private String author;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MessagesAdapter();
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        editTextEnterMassage = findViewById(R.id.editTextEnterMassage);
        imageViewAddImage = findViewById(R.id.imageViewAddImage);
        imageViewSendMessage = findViewById(R.id.imageViewSendMessage);
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(adapter);
        messages = new ArrayList<>();
        author = "Serge";
        imageViewSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage(){
        String messageText = editTextEnterMassage.getText().toString().trim();
        if (!messageText.isEmpty()){
            messages.add(new Message(author,messageText));
            adapter.setMessages(messages);
            editTextEnterMassage.setText("");
            recyclerViewMessages.scrollToPosition(adapter.getItemCount()-1);
        }
    }

}