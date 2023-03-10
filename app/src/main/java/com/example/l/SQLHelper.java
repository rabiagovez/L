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
                    Books books = new Books(rst.getInt("ID"),rst.getString("Name"), rst.getString("Category"), rst.getString("Writer"), rst.getInt("Year"), rst.getString("Publisher"), rst.getString("ISBN"));
                    booksList.add(books);
                }

            }


        } catch (Exception ex) {
            Log.e("Mes", ex.getMessage());
        }
        //Log.e("A",booksList.get(0).getCategory());
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
                    Books books = new Books(rst.getInt("ID"),rst.getString("Name"), rst.getString("Category"), rst.getString("Writer"), rst.getInt("Year"), rst.getString("Publisher"), rst.getString("ISBN"));
                    booksList.add(books);
                }

            }


        } catch (Exception ex) {
            Log.e("Mes", ex.getMessage());
        }
        //Log.e("A",booksList.get(0).getCategory());
        return booksList;
    }
    public void addNewBook(String name,String writer,String year,String category,String publisher,String isbn){
        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionclass();
            if (connect != null) {
                String query = "insert into Books (Name,Year,Writer,Category,Publisher,ISBN) values ('"+name+"','"+year+"','"+writer+"','"+category+"','"+publisher+"','"+isbn+"')";
                Statement st = connect.createStatement();
                st.executeQuery(query);
                connect.close();
            }
        } catch (Exception ex) {
        }
    }
    public void updateBook(String name,String writer,String year,String category,String publisher,String isbn,int id){
        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionclass();
            if (connect != null) {
                String query = "update Books set Name='"+name+"',Year='"+year+"',Writer='"+writer+"',Category='"+category+"',Publisher='"+publisher+"',ISBN='"+isbn+"' where ID='"+(id)+"'";
                Statement st = connect.createStatement();
                st.executeQuery(query);
                connect.close();
            }
        } catch (Exception ex) {
            Log.e("A",ex.getMessage());
        }
    }
    public void removeBook(int id){
        try {

            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionclass();
            if (connect != null) {
                String query = "delete from Books where ID='"+(id)+"'";
                Statement st = connect.createStatement();
                st.executeQuery(query);
                connect.close();
            }
        } catch (Exception ex) {
        }}







        //
        public List<Users> readUsers(List<Users> usersList) {


            try {
                ConnectionHelper connectionHelper = new ConnectionHelper();
                connect = connectionHelper.connectionclass();
                if (connect != null) {
                    String query = "select * from Users";
                    Statement st = connect.createStatement();
                    ResultSet rst = st.executeQuery(query);
                    while (rst.next()) {
                        Users users = new Users(rst.getString("Member Name"), rst.getString("Membership Date"), rst.getString("Member Mail"),  rst.getString("Member Phone"));
                        usersList.add(users);
                    }

                }


            } catch (Exception ex) {
                Log.e("Mes", ex.getMessage());
            }
            return usersList;

        }

        public List<Users> readUsers(List<Users> usersList,String parameter,String username) {


            try {
                ConnectionHelper connectionHelper = new ConnectionHelper();
                connect = connectionHelper.connectionclass();
                if (connect != null) {
                    String query = "select * from Users where "+parameter+" like '%"+username+"%'";
                    Statement st = connect.createStatement();
                    ResultSet rst = st.executeQuery(query);
                    while (rst.next()) {
                        Users users = new Users(rst.getString("Member Name"), rst.getString("Membership Date"), rst.getString("Member Mail"), rst.getString("Member Phone"));
                        usersList.add(users);
                    }

                }


            } catch (Exception ex) {
                Log.e("Mes", ex.getMessage());
            }
            //Log.e("A",booksList.get(0).getCategory());
            return usersList;
        }
        public void addNewUser(String memberName,String membershipDate,String memberMail,String memberPhone){
            try {

                ConnectionHelper connectionHelper = new ConnectionHelper();
                connect = connectionHelper.connectionclass();
                if (connect != null) {
                    String query = "insert into Users (Name,Date,Mail,Phone) values ('"+memberName+"','"+membershipDate+"','"+memberMail+"','"+memberPhone+"')";
                    Statement st = connect.createStatement();
                    st.executeQuery(query);
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
        public void updateUsers(String memberName,String membershipDate,String memberMail,String memberPhone, int id){
            try {

                ConnectionHelper connectionHelper = new ConnectionHelper();
                connect = connectionHelper.connectionclass();
                if (connect != null) {
                    String query = "update Users set Name='"+memberName+"',Date='"+membershipDate+"',Mail='"+memberMail+"',Phone='"+memberPhone+"' where ID='"+id+"'";
                    Statement st = connect.createStatement();
                    st.executeQuery(query);
                    connect.close();
                }
            } catch (Exception ex) {
            }
        }
          public void removeUsers(int id){
              try {

                  ConnectionHelper connectionHelper = new ConnectionHelper();
                  connect = connectionHelper.connectionclass();
                  if (connect != null) {
                      String query = "delete from Books where ID='"+id+"'";
                      Statement st = connect.createStatement();
                      st.executeQuery(query);
                      connect.close();
                  }
              }   catch (Exception ex) {
            }
    }
}


