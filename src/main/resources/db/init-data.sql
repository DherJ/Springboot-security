INSERT INTO roles(name) VALUES ('USER');
INSERT INTO roles(name) VALUES ('MODERATOR');
INSERT INTO roles(name) VALUES ('ADMIN');

INSERT INTO users(username,password,email) VALUES ('jerome','$2a$10$3iaM.e/O5IFbYs0wnQEBv.tizF3Fi43VBxmG0CBDbzhgnHraV0VY6', 'jerome@jerome.com');
INSERT INTO users(username,password,email) VALUES ('toto','$2a$10$3iaM.e/O5IFbYs0wnQEBv.tizF3Fi43VBxmG0CBDbzhgnHraV0VY6', 'toto@toto.com');
INSERT INTO users(username,password,email) VALUES ('tata','$2a$10$3iaM.e/O5IFbYs0wnQEBv.tizF3Fi43VBxmG0CBDbzhgnHraV0VY6', 'tata@tata.com');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);

INSERT INTO pets(id, name, description, species,weight) VALUES (1, 'Papuche','Je suis un tyrant', 'Catisfaction', 5);
INSERT INTO pets(id, name, description, species,weight) VALUES (2, 'Bouh','Je suis timide', 'Catisfaction', 5);
INSERT INTO pets(id, name, description, species,weight) VALUES (3, 'Neko','Je suis noir', 'Patée', 7);
INSERT INTO pets(id, name, description, species,weight) VALUES (4, 'Lucifer','Je suis un tyrant', 'Patée', 6);
INSERT INTO pets(id, name, description, species,weight) VALUES (5, 'Rubben','Je suis timide', 'Patée', 6);
INSERT INTO pets(id, name, description, species,weight) VALUES (6, 'Prunnelle','Je suis un tyrant', 'Patée', 5);
INSERT INTO pets(id, name, description, species,weight) VALUES (7, 'Rocky','Je suis chiant', 'Patée', 6);
INSERT INTO pets(id, name, description, species,weight) VALUES (8, 'Pumba','Je suis gros', 'Patée', 7);

INSERT INTO foods(id, description) VALUES (1, 'Caticfaction poulet');
INSERT INTO foods(id, description) VALUES (2, 'Patée gelée');
INSERT INTO foods(id, description) VALUES (3, 'Patée sauce');
INSERT INTO foods(id, description) VALUES (4, 'Patée terrine');

INSERT INTO food_pets (pet_id, food_id) VALUES (1, 2);
INSERT INTO food_pets (pet_id, food_id) VALUES (1, 3);
INSERT INTO food_pets (pet_id, food_id) VALUES (1, 4);
INSERT INTO food_pets (pet_id, food_id) VALUES (2, 1);
INSERT INTO food_pets (pet_id, food_id) VALUES (3, 1);
INSERT INTO food_pets (pet_id, food_id) VALUES (3, 2);
INSERT INTO food_pets (pet_id, food_id) VALUES (3, 3);
INSERT INTO food_pets (pet_id, food_id) VALUES (3, 4);
INSERT INTO food_pets (pet_id, food_id) VALUES (4, 2);
INSERT INTO food_pets (pet_id, food_id) VALUES (4, 3);
INSERT INTO food_pets (pet_id, food_id) VALUES (4, 4);
INSERT INTO food_pets (pet_id, food_id) VALUES (5, 2);
INSERT INTO food_pets (pet_id, food_id) VALUES (5, 3);
INSERT INTO food_pets (pet_id, food_id) VALUES (5, 4);
INSERT INTO food_pets (pet_id, food_id) VALUES (6, 2);
INSERT INTO food_pets (pet_id, food_id) VALUES (6, 3);
INSERT INTO food_pets (pet_id, food_id) VALUES (6, 4);
INSERT INTO food_pets (pet_id, food_id) VALUES (7, 2);
INSERT INTO food_pets (pet_id, food_id) VALUES (7, 3);
INSERT INTO food_pets (pet_id, food_id) VALUES (7, 4);
INSERT INTO food_pets (pet_id, food_id) VALUES (8, 2);
INSERT INTO food_pets (pet_id, food_id) VALUES (8, 3);
INSERT INTO food_pets (pet_id, food_id) VALUES (8, 4);