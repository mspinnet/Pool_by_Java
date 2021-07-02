package edu.school21.chat.models;

import java.util.ArrayList;

public class User {

    private Long u_id;
    private String u_login;
    private String u_password;
    private ArrayList<Chatroom> creted_rooms;
    private ArrayList<Chatroom> u_socializes;

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
        res = "User [u_id=" + u_id
                + ", u_login=" + u_login
                + ", u_password=" + u_password
                + "]";
        return res;
    }
}
