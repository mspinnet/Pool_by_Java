package edu.school21.chat.app;

import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.Scanner;
import java.time.LocalDate;

public class Program {
    public static void main(String[] args) {

        final String user = "mspinnet";
        final String password = "1";
        final String url = "jdbc:postgresql://localhost:5432/data1";
        HikariConfig config = new HikariConfig();
        Date now1 = Date.valueOf(LocalDate.now());
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        HikariDataSource ds = new HikariDataSource(config);
        MessagesRepositoryJdbcImpl my1 = new MessagesRepositoryJdbcImpl(ds);
        User creator = new User(4L, "user", "user", null, null);
        User author = creator;
        Chatroom room = new Chatroom(1L, "room", creator, null);
        Message message = new Message(null, author, room, "hello", now1);
        my1.save(message);
        System.out.println(message.getID());
        System.out.print("Message : ");
        System.out.println(my1.findById(message.getID()).get());
    }
}
