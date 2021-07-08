CREATE TABLE users
(
    username character varying(20) NOT NULL,
    password character varying(120) NOT NULL,
    email character varying(50) NOT NULL,
    id SERIAL NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE roles
(
    name character varying(20) NOT NULL,
    id SERIAL NOT NULL,
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