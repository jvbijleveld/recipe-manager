-- CREATE TABLE RECIPE --
CREATE TABLE recipe_schema.recipe (
    id serial primary key,
    name varchar(128) not null,
    serves int
);
CREATE UNIQUE INDEX recipe_uidx ON recipe_schema.recipe(name);

-- CREATE TABLE INSTRUCTION --
CREATE TABLE recipe_schema.instruction (
    id serial primary key,
    recipe bigint not null,
    step int not null,
    action varchar(32),
    description varchar(512),
    duration bigint
);
ALTER TABLE recipe_schema.instruction ADD CONSTRAINT instruction_recipe_fk1 FOREIGN KEY (recipe) REFERENCES recipe_schema.recipe (id);
CREATE INDEX instruction_recipe_idx ON recipe_schema.instruction(recipe);

-- CREATE TABLE INGREDIENT --
CREATE TABLE recipe_schema.ingredient (
    id serial primary key,
    instruction bigint not null,
    name varchar(128),
    amount int,
    unit varchar(64)
);
ALTER TABLE recipe_schema.ingredient ADD CONSTRAINT ingredient_instruction_fk1 FOREIGN KEY (instruction) REFERENCES recipe_schema.instruction (id);
CREATE INDEX ingredient_instruction_idx on recipe_schema.ingredient(instruction);
