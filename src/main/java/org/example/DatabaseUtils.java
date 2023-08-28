package org.example;

import org.example.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
    public static Connection getConnection() {
        Connection connection = null;
        try {
           connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                  "postgres",
                  "postgres");
      } catch (SQLException e){
          System.out.println(e.getMessage());
      }
        return connection;
    }



}

