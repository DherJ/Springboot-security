# Springboot-security
Spring boot with authorities management

Install :
mvn update
Run SpringSecurityApplication (server run on port 8081)

Needs :
Postgres data base named testdb
scripts to init data in test/resources/import.sql

Config available in src/resources/application.properties


## Authorithies management

Authorities of user are stored in table 'user_roles';

Spring security check the authorities of connected user to define if he has rights to acces on api resource in WebSecurityConfig

# Build docker
docker-compose up --build
