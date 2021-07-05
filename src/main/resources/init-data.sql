
CREATE TABLE users
(
    username character varying(20) NOT NULL,
    password character varying(120) NOT NULL,
    email character varying(50) NOT NULL,
    id integer SERIAL NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE roles
(
    name character varying(20) NOT NULL,
    id integer SERIAL NOT NULL,
    CONSTRAINT roles_pkey PRIMARY KEY (id)
);


CREATE TABLE user_roles
(
    user_id integer NOT NULL,
    role_id integer NOT NULL,
    CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id),
    CONSTRAINT role_fk FOREIGN KEY (role_id) REFERENCES roles (id),
    CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO roles(name) VALUES ('"USER"');
INSERT INTO roles(name) VALUES ('"MODERATOR"');
INSERT INTO roles(name) VALUES ('"ADMIN"');

INSERT INTO users(username,password,email)
VALUES ('jerome','$2a$10$3iaM.e/O5IFbYs0wnQEBv.tizF3Fi43VBxmG0CBDbzhgnHraV0VY6', 'jerome@jerome.com');
INSERT INTO users(username,password,email)
VALUES ('toto','$2a$10$3iaM.e/O5IFbYs0wnQEBv.tizF3Fi43VBxmG0CBDbzhgnHraV0VY6', 'toto@toto.com');
INSERT INTO users(username,password,email)
VALUES ('tata','$2a$10$3iaM.e/O5IFbYs0wnQEBv.tizF3Fi43VBxmG0CBDbzhgnHraV0VY6', 'tata@tata.com');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);