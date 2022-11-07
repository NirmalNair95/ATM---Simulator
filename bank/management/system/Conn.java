package bank.management.system;


import java.sql.*;



public class Conn {

    Connection c;
    static Statement s;


    public Conn(){

        try{
            // Creating connection with mysql
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root@1234#");

            //Create Statement
            s=c.createStatement();

        }catch (Exception e){
            System.out.println(e);      //Execute Query
        }


    }
}