-- Insert sample categories
INSERT INTO category (id, description, name)
VALUES
    (nextval('category_seq'), 'Electronics devices including phones, laptops, etc.', 'Electronics'),
    (nextval('category_seq'), 'Clothing items for men, women, and children', 'Clothing'),
    (nextval('category_seq'), 'Groceries and daily essentials', 'Groceries');

-- Insert sample products
-- Insert sample products
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Smartphone with 128GB storage', 'Smartphone', 50, 699.99,
     (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), '4K Ultra HD Smart TV', 'Smart TV', 30, 1200.50,
     (SELECT id FROM category WHERE name = 'Electronics')),
    (nextval('product_seq'), 'Men''s Casual T-Shirt', 'T-Shirt', 100, 19.99,
     (SELECT id FROM category WHERE name = 'Clothing')),
    (nextval('product_seq'), 'Organic Whole Milk - 1 Gallon', 'Milk', 200, 3.99,
     (SELECT id FROM category WHERE name = 'Groceries')),
    (nextval('product_seq'), 'Women''s Running Shoes', 'Running Shoes', 60, 59.99,
     (SELECT id FROM category WHERE name = 'Clothing')),
    (nextval('product_seq'), 'Bag of Fresh Apples', 'Apples', 150, 4.50,
     (SELECT id FROM category WHERE name = 'Groceries'));
