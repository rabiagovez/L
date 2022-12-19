package com.example.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ListBooksActivity extends AppCompatActivity {
List<Books> booksList=new ArrayList<Books>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);

        SQLHelper sqlHelper = new SQLHelper();
        sqlHelper.readBooks(booksList);
        SetListView();
        EditText editText=findViewById(R.id.edittextfind);
        EditText editText2=findViewById(R.id.edittextfind2);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(editText.getText().length()!=0) {
                booksList.clear();
                sqlHelper.readBooks(booksList, "Name",editText.getText().toString());
                SetListView();
            }else{
                booksList.clear();
                sqlHelper.readBooks(booksList);
                SetListView();
            }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText2.getText().length()!=0) {
                    booksList.clear();
                    sqlHelper.readBooks(booksList, "Writer",editText2.getText().toString());
                    SetListView();
                }else{
                    booksList.clear();
                    sqlHelper.readBooks(booksList);
                    SetListView();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void SetListView(){
        ListView listView = findViewById(R.id.listview);
        Adapter adapter = new Adapter(this);
        listView.setAdapter(adapter);
    }
    class Adapter extends ArrayAdapter {
        Context context;

        Adapter(Context c) {
            super(c, R.layout.listitemlistbooks,R.id.textName,booksList);
            this.context = c;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listitemlistbooks, parent, false);

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