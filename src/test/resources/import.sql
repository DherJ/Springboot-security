DELETE FROM user_roles;
DELETE FROM roles;
DELETE FROM users;
DELETE FROM pets;
DELETE FROM foods;
DELETE FROM food_pets;


INSERT INTO roles(id, name) VALUES (1, 'USER');
INSERT INTO roles(id, name) VALUES (2, 'MODERATOR');
INSERT INTO roles(id, name) VALUES (3, 'ADMIN');

INSERT INTO users(id, username,password,email) VALUES (1, 'toto','toto', 'toto@toto.com');
INSERT INTO users(id, username,password,email) VALUES (2, 'tata','tata', 'tata@tata.com');
INSERT INTO users(id, username,password,email) VALUES (3, 'titi','titi', 'titi@titi.com');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);

INSERT INTO pets(id, name,species,weight) VALUES (1, 'Neko','Patée', 8);
INSERT INTO pets(id, name,species,weight) VALUES (2, 'Papuche','Catisfaction', 5);
INSERT INTO pets(id, name,species,weight) VALUES (3, 'Bouh','Catisfaction', 6);

INSERT INTO foods(id, description) VALUES (1, 'Caticfaction poulet');
INSERT INTO foods(id, description) VALUES (2, 'Patée gelée');
INSERT INTO foods(id, description) VALUES (3, 'Patée sauce');
INSERT INTO foods(id, description) VALUES (4, 'Patée terrine');

INSERT INTO food_pets (pet_id, food_id) VALUES (1, 2);
INSERT INTO food_pets (pet_id, food_id) VALUES (1, 3);
INSERT INTO food_pets (pet_id, food_id) VALUES (1, 4);
INSERT INTO food_pets (pet_id, food_id) VALUES (2, 1);
INSERT INTO food_pets (pet_id, food_id) VALUES (3, 1);