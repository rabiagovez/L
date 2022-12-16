package com.example.l;

import android.content.Intent;
import android.util.Log;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLHelper {
Connection connect;
String ConnectionResult="";
    public boolean ReadData(String type,String username,String password){
        boolean status=false;

        try{
            ConnectionHelper connectionHelper=new ConnectionHelper();
            connect=connectionHelper.connectionclass();
            if(connect!=null){
                String query="select * from "+type+" where UserName='"+username+"' and Password='"+password+"'";
                Statement st=connect.createStatement();
                ResultSet rst=st.executeQuery(query);
                status= rst.next();

            }



        }

        catch (Exception ex){
            Log.e("Mes",ex.getMessage());}
            return status;
    }
}
