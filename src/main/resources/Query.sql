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
customerMobileNumber varchar(20) not null,
customerNameonCard varchar(40) not null,
customerCVV int(3) not null,
customerCardNumber varchar(20) not null,
customerExpiry varchar(15) not null,
unique (customerID),
primary key (customerID));

create table if not exists bookDetails (bookID int(10) not null auto_increment,
bookIcon mediumblob,
bookName varchar(20) not null,
bookType varchar(10) not null,
bookAvailability int(10) not null,
bookPrice varchar(10) not null,
unique (bookID),
primary key (bookID));

insert into bookdetails (bookID, bookIcon, bookName, bookType, bookAvailability, bookPrice) 
values (0001, null, 'Harry Potter', 'Sci-Fi', 10, '$100');