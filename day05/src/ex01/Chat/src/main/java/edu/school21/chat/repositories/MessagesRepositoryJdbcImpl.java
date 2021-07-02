package edu.school21.chat.repositories;

import edu.school21.chat.models.*;

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
}
