CREATE DATABASE moneybook;

use moneybook;

CREATE TABLE expense(
id int(11) auto_increment PRIMARY KEY,
name varchar(255),
price int(11),
type varchar(255),
date date
)
