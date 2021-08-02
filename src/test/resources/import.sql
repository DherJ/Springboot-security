DELETE FROM user_roles;
DELETE FROM roles;
DELETE FROM users;

INSERT INTO roles(id, name) VALUES (1, 'USER');
INSERT INTO roles(id, name) VALUES (2, 'MODERATOR');
INSERT INTO roles(id, name) VALUES (3, 'ADMIN');

INSERT INTO users(id, username,password,email) VALUES (1, 'toto','toto', 'toto@toto.com');
INSERT INTO users(id, username,password,email) VALUES (2, 'tata','tata', 'tata@tata.com');
INSERT INTO users(id, username,password,email) VALUES (3, 'titi','titi', 'titi@titi.com');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);