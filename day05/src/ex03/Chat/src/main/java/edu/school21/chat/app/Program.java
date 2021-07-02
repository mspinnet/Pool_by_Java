package edu.school21.chat.app;

import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.Optional;
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
        Optional<Message> mes = my1.findById(11L);
        if (mes.isPresent()) {
            Message message = mes.get();
            message.setText("Bay");
            message.setDate(now1);
            my1.update(message);
            System.out.print("Message : ");
            System.out.println(my1.findById(message.getID()).get());
        }
    }
}
