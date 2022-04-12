CREATE TABLE users
(
    id SERIAL NOT NULL,
    username character varying(20) NOT NULL,
    password character varying(120) NOT NULL,
    email character varying(50) NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id SERIAL NOT NULL,
    name character varying(20) NOT NULL,
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


CREATE TABLE pets
(
    id SERIAL NOT NULL,
    name character varying(20) NOT NULL,
    description character varying(80) NOT NULL,
    species character varying(20) NOT NULL,
    weight int NOT NULL,
    CONSTRAINT pets_pkey PRIMARY KEY (id)
);


CREATE TABLE foods
(
    id SERIAL NOT NULL,
    description character varying(200) NOT NULL,
    CONSTRAINT foods_pkey PRIMARY KEY (id)
);


CREATE TABLE food_pets
(
    food_id integer NOT NULL,
    pet_id integer NOT NULL,
    CONSTRAINT food_pets_pkey PRIMARY KEY (food_id, pet_id),
    CONSTRAINT pet_fk FOREIGN KEY (pet_id) REFERENCES pets (id),
    CONSTRAINT food_fk FOREIGN KEY (food_id) REFERENCES foods (id)
);