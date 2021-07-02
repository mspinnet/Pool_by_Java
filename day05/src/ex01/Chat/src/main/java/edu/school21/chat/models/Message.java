package edu.school21.chat.models;

import edu.school21.chat.repositories.MessagesRepository;

import java.util.Date;

public class Message {

    private Long m_id;
    private User m_author;
    private Chatroom m_room;
    private String m_text;
    private Date m_data;

    public Message(Long id, User author, Chatroom room, String text, Date time)
    {
        m_id = id;
        m_author = author;
        m_room = room;
        m_text = text;
        m_data = time;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Message tmp = (Message) o;
        return m_id == tmp.m_id;
    }

    @Override
    public int hashCode()
    {
        return Long.valueOf(m_id).hashCode();
    }

    @Override
    public String toString()
    {
        String res;
        res = "{\n id=" + m_id
                + ",\n author=" + m_author
                + ",\n room=" + m_room
                + ",\n text=\"" + m_text
                + "\",\n dateTime=" + m_data +"\n}";
        return res;
    }
}
