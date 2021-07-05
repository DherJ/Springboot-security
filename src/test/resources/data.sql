

CREATE TABLE users
(
    username character varying(20) NOT NULL,
    password character varying(120) NOT NULL,
    email character varying(50) NOT NULL,
    id integer NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE roles
(
    name character varying(20) NOT NULL,
    id integer NOT NULL,
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

INSERT INTO roles(id, name) VALUES (1, '"USER"');
INSERT INTO roles(id, name) VALUES (2, '"MODERATOR"');
INSERT INTO roles(id, name) VALUES (3, '"ADMIN"');

INSERT INTO users(id, username,password,email)
VALUES (1, 'toto','toto', 'toto@toto.com');
INSERT INTO users(id, username,password,email)
VALUES (2, 'tata','tata', 'tata@tata.com');
INSERT INTO users(id, username,password,email)
VALUES (3, 'titi','titi', 'titi@titi.com');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);