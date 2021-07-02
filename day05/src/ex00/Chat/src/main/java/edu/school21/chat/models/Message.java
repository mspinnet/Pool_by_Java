package edu.school21.chat.models;

import java.util.Date;

public class Message {

    private Long m_id;
    private User m_author;
    private Chatroom m_room;
    private String m_text;
    private Date m_data;

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
        res = "User [m_id=" + m_id
                + ", m_author=" + m_author
                + ", m_room=" + m_room
                + ", m_text=" + m_text
                + ", m_data=" + m_data +"]";
        return res;
    }
}
