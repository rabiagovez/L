package com.example.l;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {
    List<Users> usersList = new ArrayList<Users>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        SQLHelper sqlHelper = new SQLHelper();

        sqlHelper.readUsers(usersList);
        SetListView();

    }

    public void SetListView(){
        ListView listView = findViewById(R.id.listviewuserlist);
        UserListActivity.Adapter adapter = new UserListActivity.Adapter(this);
        listView.setAdapter(adapter);
    }

    class Adapter extends ArrayAdapter {
        Context context;

    Adapter(Context c) {
        super(c, R.layout.listitemlistbooks,R.id.textName,usersList);
        this.context = c;

    }




    }
}