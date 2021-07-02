package edu.school21.chat.repositories;

import edu.school21.chat.models.*;
import edu.school21.chat.app.NotSavedSubEntityException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private DataSource _ds;

    public MessagesRepositoryJdbcImpl(DataSource ds)
    {
        _ds = ds;
    }

    public Optional<Message> findById(Long id)
    {
        Long byAuthor = 0L;
        Long byRoom = 0L;
        Long u_id = 0L;
        Long c_id = 0L;
        String byText = "";
        Date byDate = null;
        String byLogin = "";
        String byPass = "";
        String byName = "";
        try
        {
            Connection connection = _ds.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM chat.messages WHERE m_id = (?)");
            statement.setLong(1, id);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                byAuthor = resultSet.getLong("m_author");
                byRoom = resultSet.getLong("m_room");
                byText += resultSet.getString("m_text");
                byDate = resultSet.getDate("m_data");
            }
            statement = connection.prepareStatement("SELECT * FROM chat.users WHERE u_id = (?)");
            statement.setLong(1, byAuthor);
            final ResultSet resultSet1 = statement.executeQuery();
            if (resultSet1.next())
            {
                u_id = resultSet1.getLong("u_id");
                byLogin += resultSet1.getString("u_login");
                byPass += resultSet1.getString("u_password");
            }
            statement = connection.prepareStatement("SELECT * FROM chat.chatrooms WHERE c_id = (?)");
            statement.setLong(1, byAuthor);
            final ResultSet resultSet2 = statement.executeQuery();
            if (resultSet2.next())
            {
                c_id = resultSet2.getLong("c_id");
                byName += resultSet2.getString("c_name");
            }
            connection.close();
            return Optional.of(new Message(id, new User(u_id, byLogin, byPass, null, null),
                    new Chatroom(c_id, byName, null, null), byText, byDate));
        }
        catch (SQLException e)
        {
            System.out.println("Exception");
        }
        return null;
    }

    public void save(Message message) throws NotSavedSubEntityException
    {
        try
        {
            Connection connection = _ds.getConnection();
            PreparedStatement statement;
            Long author_id = message.getAuthor().getID();
            Long room_id = message.getRoom().getID();
            statement = connection.prepareStatement("SELECT * FROM chat.users WHERE u_id = (?)");
            statement.setLong(1, author_id);
            final ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                    throw new NotSavedSubEntityException();
            }
            statement = connection.prepareStatement("SELECT * FROM chat.chatrooms WHERE c_id = (?)");
            statement.setLong(1, room_id);
            final ResultSet resultSet1 = statement.executeQuery();
            if (!resultSet1.next()) {
                    throw new NotSavedSubEntityException();
            }
            statement = connection.prepareStatement("INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data)" +
                    "VALUES (DEFAULT, (?), (?), (?), (?)) RETURNING m_id");
            statement.setLong(1, author_id);
            statement.setLong(2, room_id);
            statement.setString(3, message.getText());
            statement.setDate(4, message.getDate());
            final ResultSet resultSet2 = statement.executeQuery();
            if (resultSet2.next())
            {
                message.setID(resultSet2.getLong("m_id"));
            }
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Exception");
        }
    }

    public void update(Message message)
    {
        try
        {
            Connection connection = _ds.getConnection();
            PreparedStatement statement;
            Long author_id = message.getAuthor().getID();
            Long room_id = message.getRoom().getID();
            String text_m = message.getText();
            Date data1 = message.getDate();
            Long id_m = message.getID();
            statement = connection.prepareStatement("SELECT * FROM chat.users WHERE u_id = (?)");
            statement.setLong(1, author_id);
            final ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new NotSavedSubEntityException();
            }
            statement = connection.prepareStatement("SELECT * FROM chat.chatrooms WHERE c_id = (?)");
            statement.setLong(1, room_id);
            final ResultSet resultSet1 = statement.executeQuery();
            if (!resultSet1.next()) {
                throw new NotSavedSubEntityException();
            }
            statement = connection.prepareStatement("UPDATE chat.messages SET m_author = (?)" +
                    ", m_room = (?) , m_text = (?) , m_data = (?) WHERE m_id = (?) RETURNING m_id");
            statement.setLong(1, author_id);
            statement.setLong(2, room_id);
            statement.setString(3, text_m);
            statement.setDate(4, data1);
            statement.setLong(5, id_m);
            final ResultSet resultSet2 = statement.executeQuery();
            connection.close();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Exception");
        }
    }
}
