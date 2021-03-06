-- this .sql file is made by Kevin Lawrence C. Manipula for java tech training capstone project


-- database for user microservices in Global Banking System project
CREATE DATABASE GBSUSERSDB;

-- switch to gbusersdb
USE GBSUSERSDB;

-- for dropping table users
-- DROP TABLE USERS;

-- creating table for users
CREATE TABLE USERS(
USER_ID BIGINT,
USER_NAME VARCHAR(15),
USER_PASSWORD VARCHAR(15),
CREATION_DATE DATETIME,
NUMBER_OF_ACCOUNTS INT,
ACCOUNT_NUMBER VARCHAR(20) UNIQUE,
TOTAL_BALANCE FLOAT,
CONTACT_NUMBER VARCHAR(10)
-- PRIMARY KEY (USER_ID)
);

-- input data into users table
INSERT INTO USERS VALUES(1, 'merry', 'christmas', '2021-11-02 01:01:01', 2, 1234567890, 40000.00, '9346758390');
INSERT INTO USERS VALUES(2, 'merry', 'christmas', '2021-11-20 02:02:02', 2, 2345678901, 23500.00, '9346758390');
INSERT INTO USERS VALUES(3, 'happy', 'newyear', '2021-11-14 03:03:03', 1, 9876543211, 53789.92, '9875998345');
INSERT INTO USERS VALUES(4, 'maligayang', 'pasko', '2021-11-23 04:04:04', 1, 8907654321, 120789.23, '9444378574');
INSERT INTO USERS VALUES(5, 'manigong', 'bagongtaon', '2021-10-28 05:05:05', 1, 7890654321, 82456.76, '9113875098');

-- selecting the users table
SELECT * FROM USERS;


-- database for accounts and transaction microservices for Global Banking System Project
CREATE DATABASE GBSACCOUNTSDB;

-- switch to gbsaccountsdb
USE GBSACCOUNTSDB;

-- for dropping table
-- DROP TABLE USER_ACCOUNTS;
-- DROP TABLE TRANSACTIONS;

-- table for user accounts
CREATE TABLE USER_ACCOUNTS(
USERACCOUNT_NUMBER VARCHAR(20) UNIQUE,
USERNAME VARCHAR(15),
ACCOUNT_BALANCE FLOAT
);

-- table for transactions
CREATE TABLE TRANSACTIONS(
TRANSACTION_ID BIGINT,
FROM_ACCOUNT VARCHAR(20),
TO_ACCOUNT VARCHAR(20),
AMOUNT FLOAT,
TRANSACTION_DATE DATETIME
);

-- selecting a table in gbsaccountsdb
SELECT * FROM USER_ACCOUNTS;
SELECT * FROM TRANSACTIONS;

-- input data into users_accounts table
INSERT INTO USER_ACCOUNTS VALUES(1234567890, 'merry', 40000.00);
INSERT INTO USER_ACCOUNTS VALUES(2345678901, 'merry', 23500.00);
INSERT INTO USER_ACCOUNTS VALUES(9876543211, 'happy', 53789.92);
INSERT INTO USER_ACCOUNTS VALUES(8907654321, 'maligayang', 120789.23);
INSERT INTO USER_ACCOUNTS VALUES(7890654321, 'manigong', 82456.76);



