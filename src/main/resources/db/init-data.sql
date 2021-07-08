INSERT INTO roles(name) VALUES ('USER');
INSERT INTO roles(name) VALUES ('MODERATOR');
INSERT INTO roles(name) VALUES ('ADMIN');

INSERT INTO users(username,password,email)
VALUES ('jerome','$2a$10$3iaM.e/O5IFbYs0wnQEBv.tizF3Fi43VBxmG0CBDbzhgnHraV0VY6', 'jerome@jerome.com');
INSERT INTO users(username,password,email)
VALUES ('toto','$2a$10$3iaM.e/O5IFbYs0wnQEBv.tizF3Fi43VBxmG0CBDbzhgnHraV0VY6', 'toto@toto.com');
INSERT INTO users(username,password,email)
VALUES ('tata','$2a$10$3iaM.e/O5IFbYs0wnQEBv.tizF3Fi43VBxmG0CBDbzhgnHraV0VY6', 'tata@tata.com');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);