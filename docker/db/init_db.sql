-- Create database
CREATE DATABASE recipe_manager ENCODING 'UTF8';

CREATE USER recipe_user PASSWORD 'db_pass';

CREATE ROLE recipe_user_role;

GRANT CONNECT on database recipe_manager TO recipe_user_role;
GRANT recipe_user_role to recipe_user;

-- Connect to database
\c recipe_manager

-- Create Schema and grant acces
CREATE SCHEMA recipe_schema AUTHORIZATION recipe_user;

ALTER DATABASE recipe_manager SET search_path = recipe_schema, "$user", public;
ALTER USER recipe_user SET search_path = recipe_schema;

GRANT ALL ON SCHEMA recipe_schema TO recipe_user;
GRANT USAGE ON SCHEMA recipe_schema TO recipe_user;