package org.example;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtils {
    @SneakyThrows
    public static Connection getConnection() {


        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres");


        return connection;
    }


}

