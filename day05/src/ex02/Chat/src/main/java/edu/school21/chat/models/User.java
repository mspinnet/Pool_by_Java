package edu.school21.chat.models;

import java.util.ArrayList;

public class User {

    private Long u_id;
    private String u_login;
    private String u_password;
    private ArrayList<Chatroom> created_rooms;
    private ArrayList<Chatroom> u_socializes;

    public User(Long id, String login, String password, ArrayList<Chatroom> rooms, ArrayList<Chatroom> socializes)
    {
        u_id = id;
        u_login = login;
        u_password = password;
        created_rooms = rooms;
        u_socializes = socializes;
    }

    public Long getID()
    {
        return u_id;
    }

    public String getLogin()
    {
        return u_login;
    }

    public String getPass()
    {
        return u_password;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User tmp = (User) o;
        return u_id == tmp.u_id;
    }

    @Override
    public int hashCode()
    {
        return Long.valueOf(u_id).hashCode();
    }

    @Override
    public String toString()
    {
        String res;
        res = "{id=" + u_id
                + ", login=\"" + u_login
                + "\", password=\"" + u_password
                + "\", createdRooms=" + created_rooms
                + ", rooms=" + u_socializes + "}";
        return res;
    }
}
