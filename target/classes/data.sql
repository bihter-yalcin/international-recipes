INSERT INTO authors (id, name) VALUES
('ca2bb8d9-ee26-4487-b024-040eb0ed7e36', 'John Doe'),
('e4b0c4f2-7ee7-4a80-b69a-83cc12ef5ee7', 'Jane Smith');

INSERT INTO recipes (id, name, description, ingredients, instructions, country, prepTime, author_id)
VALUES
('3b4ac6bd-c918-41a1-b3b7-26c2177d556d', 'Spaghetti Carbonara', 'Classic Italian pasta dish', 'Spaghetti, Eggs, Pancetta, Parmesan cheese, Black pepper', '1. Cook spaghetti according to package instructions ...', 'Italy', 20, 'ca2bb8d9-ee26-4487-b024-040eb0ed7e36'),
('3d3f3f23-1d60-45d0-bb47-d8c49c0cfe3c', 'Chicken Tikka Masala', 'Popular Indian curry dish', 'Chicken, Yogurt, Tomato sauce, Spices', '1. Marinate chicken in yogurt and spices ...', 'India', 30, 'e4b0c4f2-7ee7-4a80-b69a-83cc12ef5ee7');