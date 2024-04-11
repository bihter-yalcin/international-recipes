DROP TABLE IF EXISTS "recipes";
DROP TABLE IF EXISTS "authors";

CREATE TABLE "authors" (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE "recipes" (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    ingredients TEXT,
    instructions TEXT,
    country VARCHAR(255),
    prepTime INT,
    author_id UUID NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);