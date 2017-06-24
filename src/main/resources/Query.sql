create database bookstore;

use bookstore;

create table if not exists customerAccount (customerID varchar(10) not null, 
customerFirstName varchar(20) not null, 
customerLastName varchar(20) not null, 
customerPassword varchar(20) not null,
customerAddress1 varchar(50) not null,
customerAddress2 varchar(50),
customerState varchar(10) not null,
customerZipCode int(5) not null,
customerMobileNumber int(10) not null,
customerNameonCard varchar(40) not null,
customerCVV int(3) not null,
customerCardNumber int(16) not null,
customerExpiry varchar(15) not null,
unique (customerID),
primary key (customerID));