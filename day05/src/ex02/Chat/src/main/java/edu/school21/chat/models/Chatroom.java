package edu.school21.chat.models;

import java.util.ArrayList;

public class Chatroom {

    private Long c_id;
    private String c_name;
    private User c_owner;
    private ArrayList<Message> c_messages;

    public Chatroom(Long id, String name, User owner, ArrayList<Message> messages)
    {
        c_id = id;
        c_name = name;
        c_owner = owner;
        c_messages = messages;
    }

    public Long getID()
    {
        return c_id;
    }

    public String getName()
    {
        return c_name;
    }

    public User getOwner()
    {
        return c_owner;
    }

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
        res = "{id=" + c_id
                + ", name=\"" + c_name
                + "\", owner=" + c_owner
                + ", messages=" + c_messages + "}";
        return res;
    }
}
