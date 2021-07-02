package edu.school21.chat.app;

import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        final String user = "mspinnet";
        final String password = "1";
        final String url = "jdbc:postgresql://localhost:5432/data1";
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        HikariDataSource ds = new HikariDataSource(config);
        MessagesRepositoryJdbcImpl my1 = new MessagesRepositoryJdbcImpl(ds);
        System.out.println("Enter a massage ID");
        Scanner in = new Scanner(System.in);
        Long id = in.nextLong();
        in.close();
        System.out.print("Message : ");
        System.out.println(my1.findById(id).get());
    }
}
