 

INSERT INTO users(user_id, name, email, password, created) VALUES (1, 'john', 'john@gmail.com', 'pw123', TO_DATE('2015-11-13', 'yyyy-MM-DD'));
INSERT INTO users(user_id, name, email, password, created)  VALUES (2, 'alex', 'alex@yahoo.com', 'pw123',  TO_DATE('2014-12-15', 'yyyy-MM-DD'));
INSERT INTO users(user_id, name, email, password, created)  VALUES (3, 'philip', 'philip@gmail.com', 'pw123',  TO_DATE('2018-05-01', 'yyyy-MM-DD'));

INSERT INTO products(product_id, title, description, price, quantity, created) VALUES (1,'Wireless Mouse', 'Battery operated mouse', 11.23, 3, TO_DATE('2018-05-01', 'yyyy-MM-DD'));
INSERT INTO products(product_id, title, description, price, quantity, created) VALUES (2, 'Wind Shield', 'Wind Shield', 15.99, 1, TO_DATE('2013-03-21', 'yyyy-MM-DD'));
INSERT INTO products(product_id, title, description, price, quantity, created) VALUES (3, 'HDMI Cable', '6 feet HDMI cable', 6.00, 4, TO_DATE('2016-07-11', 'yyyy-MM-DD'));


INSERT INTO orders(order_id, name,address, city, zip, status, comment, total_price,credit_card_num, user_id_fk, product_id_fk, quantity) VALUES (1, 'john', '1 winter walk dr ', 'Bowie', '12589',  'COMPLETED', 'test comment', '232.99', '5656-7689-2323-2837', 1,1, 1);
INSERT INTO orders(order_id, name,address, city, zip, status, comment, total_price,credit_card_num, user_id_fk, product_id_fk, quantity) VALUES (2, 'alex', '1 painted walk dr ', 'Annapolis', '12589',  'IN_PROGRESS', 'test comment', '112.57', '1281-1291-4854-3434', 2,2, 1);
INSERT INTO orders(order_id, name,address, city, zip, status, comment, total_price,credit_card_num, user_id_fk, product_id_fk, quantity) VALUES (3, 'philip', '1 autumn walk dr ', 'Rockville', '22345',  'CREATED', 'test credit card number', '32.57', '1212-1212', 3,3, 1);
 
