DROP TABLE users IF EXISTS;
DROP TABLE orders IF EXISTS;
DROP TABLE products IF EXISTS;

CREATE TABLE users (
  user_id         INTEGER  PRIMARY KEY,
  name VARCHAR(30),
  email  VARCHAR(50),
  password VARCHAR(30),
  created DATE
);

CREATE TABLE products (
  product_id         INTEGER  PRIMARY KEY,
  title  VARCHAR(50),
  description VARCHAR(60),
  price DECIMAL(8, 2),
  quantity INTEGER,
  created DATE
);

--Indexing the quantity column because of the query in WHERE clause.

CREATE INDEX product_qty ON products(quantity);

CREATE TABLE orders (
  order_id         INTEGER  PRIMARY KEY,
  name VARCHAR(30),
  address  VARCHAR(50),
  city VARCHAR(30),
  zip VARCHAR(30),
  status VARCHAR(30),
  comment VARCHAR(30),
  total_price DECIMAL(10, 2),
  credit_card_num VARCHAR(30) not null,
  user_id_fk INTEGER,
  product_id_fk INTEGER,
  quantity INTEGER,
  foreign key(user_id_fk) references users(user_id),
  foreign key(product_id_fk) references products(product_id)
);


