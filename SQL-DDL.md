```sql
DROP DATABASE IF EXISTS multisub;

CREATE DATABASE multisub;
USE multisub;


DROP TABLE IF EXISTS coupon;
DROP TABLE IF EXISTS useres;
DROP TABLE IF EXISTS couponDetail;
DROP TABLE IF EXISTS usersType;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS topping;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS nutrition;
DROP TABLE IF EXISTS orders;

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
    nutId INT
);

ALTER TABLE product
ADD FOREIGN KEY (nutid) REFERENCES nutrition (id);

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
	id INT primary KEY NOT NULL,
    name VARCHAR(30),
	discount double,
    regdate DATE NOT NULL,
    expirDate DATE,
    expirYN INT NOT NULL
    
);

-- create usersType tables
CREATE TABLE usersType(
	id INT PRIMARY KEY,
    userType VARCHAR(10),
    regdate Date
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
    membersip Varchar(30) NOT NULL,
    couponId INT,
    regdate date
);

-- create couponDetail tables
CREATE TABLE couponDetail (
	id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	state VARCHAR(10) NOT NULL,
	useDate Date NOT NULL,
    userId VARCHAR(30),
    couponId INT
);

ALTER TABLE couponDetail
ADD FOREIGN KEY (userId) REFERENCES users (id);
ALTER TABLE couponDetail
ADD FOREIGN KEY (couponId) REFERENCES coupon (id);


-- create orders table
CREATE TABLE orders (
	id int primary KEY AUTO_INCREMENT NOT NULL,
    price INT NOT NULL,
    amount INT NOT NULL,
    payInfo VARCHAR(10),
    regdate Date NOT NULL,
    payState Varchar(10),
    udate DATE,
    productId INT NOT NULL,
    usersID VARCHAR(30) NOT NULL,
    couponDId INT
);

ALTER TABLE orders
ADD FOREIGN KEY (productId) REFERENCES product(id);
ALTER TABLE orders
ADD FOREIGN KEY (usersID) REFERENCES users (id);
ALTER TABLE orders
ADD FOREIGN KEY (couponDId) REFERENCES couponDetail (id);
```

