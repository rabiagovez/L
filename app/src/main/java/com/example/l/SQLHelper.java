package com.example.l;

import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class SQLHelper {
    Connection connect;
    String ConnectionResult = "";

    public boolean readData(String type, String username, String password) {
        boolean status = false;

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionclass();
            if (connect != null) {
                String query = "select * from " + type + " where UserName='" + username + "' and Password='" + password + "'";
                Statement st = connect.createStatement();
                ResultSet rst = st.executeQuery(query);
                status = rst.next();

            }


        } catch (Exception ex) {
            Log.e("Mes", ex.getMessage());
        }
        return status;
    }

    public List<Books> readBooks(List<Books> booksList) {


        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionclass();
            if (connect != null) {
                String query = "select * from Books";
                Statement st = connect.createStatement();
                ResultSet rst = st.executeQuery(query);
                while (rst.next()) {
                    Books books = new Books(rst.getString("Name"), rst.getString("Category"), rst.getString("Writer"), rst.getInt("Year"), rst.getString("Publisher"), rst.getString("ISBN"));
                    booksList.add(books);
                }

            }


        } catch (Exception ex) {
            Log.e("Mes", ex.getMessage());
        }
        Log.e("A",booksList.get(0).getCategory());
        return booksList;
    }
    public List<Books> readBooks(List<Books> booksList,String parameter,String bookname) {


        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionclass();
            if (connect != null) {
                String query = "select * from Books where "+parameter+" like '%"+bookname+"%'";
                Statement st = connect.createStatement();
                ResultSet rst = st.executeQuery(query);
                while (rst.next()) {
                    Books books = new Books(rst.getString("Name"), rst.getString("Category"), rst.getString("Writer"), rst.getInt("Year"), rst.getString("Publisher"), rst.getString("ISBN"));
                    booksList.add(books);
                }

            }


        } catch (Exception ex) {
            Log.e("Mes", ex.getMessage());
        }
        //Log.e("A",booksList.get(0).getCategory());
        return booksList;
    }


}


