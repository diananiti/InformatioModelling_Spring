package io.swagger.dao;
import java.sql.*;
public class dbAdapter {
    String jdbUrl="jdbc:postgresql://localhost:5432/Airport";
    String username="postgres";
    String password="redcrane20";

    //database variables

    Connection conn=null;
     Statement stnt=null;
     ResultSet rs=null;

     //create constructor
    public dbAdapter(){

    }
public void connect (){
    try {
        conn=DriverManager.getConnection(jdbUrl,username,password);

        //print ok
        System.out.println("database conection established");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}//connect

    public void disconect(){

        try{

            if(stnt != null){
                stnt.close();
            }
            if (rs!=null){
                rs.close();
            }
            if(conn != null){
                conn.close();
            }


        }catch(Exception e){
            e.printStackTrace();;
        }



    }//disconnect databse





}
