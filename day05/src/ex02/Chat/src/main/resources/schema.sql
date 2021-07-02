CREATE DATABASE data1 ENCODING 'UTF-8';

CREATE SCHEMA IF NOT EXISTS chat;

    CREATE TABLE IF NOT EXISTS chat.users (
        u_id            SERIAL PRIMARY KEY,
        u_login         VARCHAR(10) UNIQUE NOT NULL,
        u_password      VARCHAR(10) UNIQUE NOT NULL);

    CREATE TABLE IF NOT EXISTS chat.chatrooms (
        c_id            SERIAL PRIMARY KEY,
        c_name          VARCHAR(10) UNIQUE NOT NULL,
        c_owner         INTEGER NOT NULL,
        FOREIGN KEY (c_owner) REFERENCES chat.users(u_id));

    CREATE TABLE IF NOT EXISTS chat.messages (
        m_id            SERIAL PRIMARY KEY,
        m_author        INTEGER NOT NULL,
        m_room          INTEGER NOT NULL,
        m_text          VARCHAR(200) NOT NULL,
        m_data          DATE    NOT NULL,
        FOREIGN KEY (m_author) REFERENCES chat.users(u_id),
        FOREIGN KEY (m_room) REFERENCES chat.chatrooms(c_id));

    CREATE VIEW chat.created_rooms AS
        SELECT c_id, c_name FROM chat.chatrooms;
    CREATE VIEW chat.user_socializes AS
        SELECT c_id, c_name FROM chat.chatrooms;
    CREATE VIEW chat.c_messages AS
        SELECT m_id, m_author, m_text FROM chat.messages;
