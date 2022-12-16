package com.example.l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
         
        Intent intent=getIntent();
       type= intent.getStringExtra("type");
        EditText editText=findViewById(R.id.edittext);
        EditText editText1=findViewById(R.id.edittext2);
        SQLHelper sqlHelper=new SQLHelper();
       Button btn=findViewById(R.id.btnlogin);
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
           if( sqlHelper.ReadData(type,editText.getText().toString(),editText1.getText().toString())){
               if(type.equals("Users")){
                   Intent intent1=new Intent(LoginActivity.this,UserScreenActivity.class);
                   startActivity(intent1);
               }
               if(type.equals("Admins")){
                   Intent intent1=new Intent(LoginActivity.this,AdminScreenActivity.class);
                   startActivity(intent1);
               }

           }else{
               Toast.makeText(LoginActivity.this, "Username or Password is uncorrect", Toast.LENGTH_SHORT).show();
           }
           }
       });
        
    }
}