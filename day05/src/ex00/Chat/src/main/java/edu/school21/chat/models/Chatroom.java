package edu.school21.chat.models;

import java.util.ArrayList;

public class Chatroom {

    private Long c_id;
    private String c_name;
    private User c_owner;
    private ArrayList<Message> c_messages;

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Chatroom tmp = (Chatroom) o;
        return c_id == tmp.c_id;
    }

    @Override
    public int hashCode()
    {
        return Long.valueOf(c_id).hashCode();
    }

    @Override
    public String toString()
    {
        String res;
        res = "User [c_id=" + c_id
                + ", c_name=" + c_name
                + ", c_owner=" + c_owner
                + "]";
        return res;
    }
}
