DROP TABLE IF EXISTS "recipes";
DROP TABLE IF EXISTS "authors";


CREATE TABLE "authors" (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE "recipes" (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    ingredients TEXT,
    instructions TEXT,
    country VARCHAR(255),
    prepTime INT,
    author_id VARCHAR(255), -- Foreign key referencing authors table
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

