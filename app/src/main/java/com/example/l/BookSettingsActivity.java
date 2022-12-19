package com.example.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookSettingsActivity extends AppCompatActivity {
    List<Books> booksList = new ArrayList<Books>();
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_settings);
        SQLHelper sqlHelper = new SQLHelper();
        sqlHelper.readBooks(booksList);
        SetListView();

        Button btn = findViewById(R.id.button11);
        Button btn2 = findViewById(R.id.button13);
        Button btn3 = findViewById(R.id.button14);
        EditText text1 = findViewById(R.id.editTextTextPersonName);
        EditText text2 = findViewById(R.id.editTextTextPersonName2);
        EditText text3 = findViewById(R.id.editTextTextPersonName4);
        EditText text4 = findViewById(R.id.editTextTextPersonName5);
        EditText text5 = findViewById(R.id.editTextTextPersonName6);
        EditText text6 = findViewById(R.id.editTextTextPersonName7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                booksList.clear();
                sqlHelper.addNewBook(text1.getText().toString(), text3.getText().toString(), text2.getText().toString(), text4.getText().toString(), text5.getText().toString(), text6.getText().toString());
                sqlHelper.readBooks(booksList);

                SetListView();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlHelper.updateBook(text1.getText().toString(), text3.getText().toString(), text2.getText().toString(), text4.getText().toString(), text5.getText().toString(), text6.getText().toString(), id);

                SetListView();
                Toast.makeText(BookSettingsActivity.this, "Updated book", Toast.LENGTH_SHORT).show();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlHelper.removeBook(id);
                booksList.clear();
                sqlHelper.readBooks(booksList);
                SetListView();

            }
        });
    }

    public void SetListView() {
        ListView listView = findViewById(R.id.listviewbs);
        Adapter adapter = new Adapter(this);
        listView.setAdapter(adapter);
    }

    class Adapter extends ArrayAdapter {
        Context context;

        Adapter(Context c) {
            super(c, R.layout.listitemlistbooks, R.id.textName, booksList);
            this.context = c;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listitemlistbooks, parent, false);

            RelativeLayout rlt = convertView.findViewById(R.id.rlt);
            rlt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    id = position;
                    Log.e("ID:", String.valueOf(id));
                    EditText text1 = findViewById(R.id.editTextTextPersonName);
                    EditText text2 = findViewById(R.id.editTextTextPersonName2);
                    EditText text3 = findViewById(R.id.editTextTextPersonName4);
                    EditText text4 = findViewById(R.id.editTextTextPersonName5);
                    EditText text5 = findViewById(R.id.editTextTextPersonName6);
                    EditText text6 = findViewById(R.id.editTextTextPersonName7);

                    text1.setText(booksList.get(position).getName());
                    text2.setText(String.valueOf(booksList.get(position).getYear()));
                    text3.setText(booksList.get(position).getWriter());
                    text4.setText(booksList.get(position).getCategory());
                    text5.setText(booksList.get(position).getPublisher());
                    text6.setText(booksList.get(position).getISBN());
                }
            });
            TextView text1 = convertView.findViewById(R.id.textName);
            TextView text2 = convertView.findViewById(R.id.textYear);
            TextView text3 = convertView.findViewById(R.id.textWriter);
            TextView text4 = convertView.findViewById(R.id.textCategory);
            TextView text5 = convertView.findViewById(R.id.textPublisher);
            text1.setText(booksList.get(position).getName());
            text2.setText(String.valueOf(booksList.get(position).getYear()));
            text3.setText(booksList.get(position).getWriter());
            text4.setText(booksList.get(position).getCategory());
            text5.setText(booksList.get(position).getPublisher());

            return convertView;

        }
    }
}