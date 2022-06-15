```sql
DROP DATABASE IF EXISTS multisub;

CREATE DATABASE multisub;
USE multisub;


DROP TABLE IF EXISTS coupon;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS useres;
DROP TABLE IF EXISTS noneusers;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS topping;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS nutrition;

-- create table nutrition
CREATE TABLE nutrition(
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    cal DOUBLE NOT NULL,
    gram DOUBLE NOT NULL,
    protein DOUBLE NOT NULL,
    fat DOUBLE NOT NULL,
    sugar DOUBLE NOT NULL,
    salt DOUBLE NOT NULL
);

-- CREATE product table
CREATE TABLE product (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	name VARCHAR(30),
	price INT,
    regdate DATE,
    imgname VARCHAR(30),
    cateid INT,
    nuId INT
);

ALTER TABLE product
ADD FOREIGN KEY (nuid) REFERENCES nutrition (id);

-- create category tables
CREATE TABLE category(
	id INT PRIMARY KEY NOT NULL,
    name VARCHAR(30),
    pid INT
);

ALTER TABLE category
ADD FOREIGN KEY (pid) REFERENCES category (id);

-- create topping table
CREATE TABLE topping (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(30),
    price INT,
    imgname VARCHAR(30),
    cateid INT
);

ALTER TABLE topping
ADD FOREIGN KEY (cateid) REFERENCES category (id);

-- create coupon tabels
CREATE TABLE coupon (
	id int primary KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(30),
	discount double,
    period DATE,
    regdate DATE
);


-- create users tables
CREATE TABLE users(
	id VARCHAR(30) PRIMARY KEY NOT NULL,
	pwd VARCHAR(30) NOT NULL,
    name VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL,
	addr VARCHAR(50) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    point INT,
    couponId INT,
    regdate date
);

ALTER TABLE users
ADD FOREIGN KEY (couponId) REFERENCES coupon (id);

-- createa noneusers tables
CREATE TABLE nonusers(
	id int primary KEY AUTO_INCREMENT NOT NULL,
    regdate DATE NOT NULL
);


-- create orders table
CREATE TABLE orders (
	id int primary KEY AUTO_INCREMENT NOT NULL,
    price INT NOT NULL,
    amount INT NOT NULL,
    productId INT NOT NULL,
    usersID VARCHAR(30) NOT NULL,
    noneUsersId INT
);

ALTER TABLE orders
ADD FOREIGN KEY (productId) REFERENCES product(id);
ALTER TABLE orders
ADD FOREIGN KEY (usersID) REFERENCES users (id);
ALTER TABLE orders
ADD FOREIGN KEY (noneUsersId) REFERENCES nonusers (id);
```

