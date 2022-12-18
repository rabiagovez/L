package com.example.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListBooksActivity extends AppCompatActivity {
    Books books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_books);
        SQLHelper sqlHelper = new SQLHelper();
        sqlHelper.readBooks(books);
        ListView listView = findViewById(R.id.listview);
        Adapter adapter = new Adapter(this);
        listView.setAdapter(adapter);

    }

    class Adapter extends ArrayAdapter {
        Context context;

        Adapter(Context c) {
            super(c, R.layout.listitemlistbooks,R.id.textName);
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
            text1.setText(books.getName());
            text2.setText(books.getWriter());
            text3.setText(books.getCategory());
            text4.setText(books.getISBN());
            text5.setText(books.getPublisher());
            return convertView;

        }
    }
}