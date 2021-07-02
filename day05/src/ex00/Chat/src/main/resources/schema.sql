CREATE DATABASE data1 ENCODING 'UTF-8';

CREATE SCHEMA IF NOT EXISTS chat;

    CREATE TABLE IF NOT EXISTS chat.users (
        u_id            SERIAL PRIMARY KEY,
        u_login         VARCHAR(10) UNIQUE NOT NULL,
        u_password      VARCHAR(10) UNIQUE NOT NULL);

        INSERT INTO chat.users (u_id, u_login, u_password) VALUES (DEFAULT, 'Max1', '1');
        INSERT INTO chat.users (u_id, u_login, u_password) VALUES (DEFAULT, 'Max2', '2');
        INSERT INTO chat.users (u_id, u_login, u_password) VALUES (DEFAULT, 'Max3', '3');
        INSERT INTO chat.users (u_id, u_login, u_password) VALUES (DEFAULT, 'Max4', '4');
        INSERT INTO chat.users (u_id, u_login, u_password) VALUES (DEFAULT, 'Max5', '5');

    CREATE TABLE IF NOT EXISTS chat.chatrooms (
        c_id            SERIAL PRIMARY KEY,
        c_name          VARCHAR(10) UNIQUE NOT NULL,
        c_owner         INTEGER NOT NULL,
        FOREIGN KEY (c_owner) REFERENCES chat.users(u_id));

        INSERT INTO chat.chatrooms (c_id, c_name, c_owner) VALUES (DEFAULT, 'room1', 1);
        INSERT INTO chat.chatrooms (c_id, c_name, c_owner) VALUES (DEFAULT, 'room2', 2);
        INSERT INTO chat.chatrooms (c_id, c_name, c_owner) VALUES (DEFAULT, 'room3', 3);
        INSERT INTO chat.chatrooms (c_id, c_name, c_owner) VALUES (DEFAULT, 'room4', 4);
        INSERT INTO chat.chatrooms (c_id, c_name, c_owner) VALUES (DEFAULT, 'room5', 5);

    CREATE TABLE IF NOT EXISTS chat.messages (
        m_id            SERIAL PRIMARY KEY,
        m_author        INTEGER NOT NULL,
        m_room          INTEGER NOT NULL,
        m_text          VARCHAR(200) NOT NULL,
        m_data          VARCHAR(10) NOT NULL,
        FOREIGN KEY (m_author) REFERENCES chat.users(u_id),
        FOREIGN KEY (m_room) REFERENCES chat.chatrooms(c_id));

        INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data) VALUES (DEFAULT, 1, 1, 'lol1', '123');
        INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data) VALUES (DEFAULT, 2, 2, 'lol2', '123');
        INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data) VALUES (DEFAULT, 3, 3, 'lol3', '123');
        INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data) VALUES (DEFAULT, 4, 4, 'lol4', '123');
        INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data) VALUES (DEFAULT, 5, 5, 'lol5', '123');
    CREATE VIEW chat.created_rooms AS
        SELECT c_id, c_name FROM chat.chatrooms;
    CREATE VIEW chat.user_socializes AS
        SELECT c_id, c_name FROM chat.chatrooms;
    CREATE VIEW chat.c_messages AS
        SELECT m_id, m_author, m_text FROM chat.messages;
