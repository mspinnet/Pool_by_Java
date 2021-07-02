INSERT INTO chat.users (u_id, u_login, u_password) VALUES (DEFAULT, 'Max1', '1');
INSERT INTO chat.users (u_id, u_login, u_password) VALUES (DEFAULT, 'Max2', '2');
INSERT INTO chat.users (u_id, u_login, u_password) VALUES (DEFAULT, 'Max3', '3');
INSERT INTO chat.users (u_id, u_login, u_password) VALUES (DEFAULT, 'Max4', '4');
INSERT INTO chat.users (u_id, u_login, u_password) VALUES (DEFAULT, 'Max5', '5');

INSERT INTO chat.chatrooms (c_id, c_name, c_owner) VALUES (DEFAULT, 'room1', 1);
INSERT INTO chat.chatrooms (c_id, c_name, c_owner) VALUES (DEFAULT, 'room2', 2);
INSERT INTO chat.chatrooms (c_id, c_name, c_owner) VALUES (DEFAULT, 'room3', 3);
INSERT INTO chat.chatrooms (c_id, c_name, c_owner) VALUES (DEFAULT, 'room4', 4);
INSERT INTO chat.chatrooms (c_id, c_name, c_owner) VALUES (DEFAULT, 'room5', 5);

INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data) VALUES (DEFAULT, 1, 1, 'lol1', current_date);
INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data) VALUES (DEFAULT, 2, 2, 'lol2', current_date);
INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data) VALUES (DEFAULT, 3, 3, 'lol3', current_date);
INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data) VALUES (DEFAULT, 4, 4, 'lol4', current_date);
INSERT INTO chat.messages (m_id, m_author, m_room, m_text, m_data) VALUES (DEFAULT, 5, 5, 'lol5', current_date);