package com.example.l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);

        Button btn3=findViewById(R.id.button3);
        Button btn4=findViewById(R.id.button4);
        Button btn5=findViewById(R.id.button5);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserScreenActivity.this,ListBooksActivity.class);
                startActivity(intent);
            }
        });




        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserScreenActivity.this,RequestActivity.class);
                startActivity(intent);
            }
        });
    }
}