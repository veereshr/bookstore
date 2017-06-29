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

create table if not exists bookDetails (bookID varchar(20) not null,
bookName varchar(20) not null,
bookType varchar(20) not null,
bookAvailability int(20) not null,
bookPrice varchar(20) not null,
unique (bookID),
primary key (bookID));

create table if not exists employee (id varchar(10) not null, 
first_name varchar(20) not null, 
last_name varchar(20) not null, 
accpass varchar(20) not null,
address1 varchar(50) not null,
address2 varchar(50),
state varchar(10) not null,
city varchar(10) not null,
zipcode int(5) not null,
mobile varchar(20) not null,
unique (id),
primary key (id));

insert into employee(id, first_name, last_name, accpass, address1, address2, state, city, zipcode, mobile) values ('admin', 'Tom', 'Potter', 'admin', '10 E Ontario Place', 'Apt #202', 'IL', 'Chicago', 60616, 3129182915);

insert into bookdetails (bookID, bookIcon, bookName, bookType, bookAvailability, bookPrice) 
values (0001, null, 'Harry Potter', 'Sci-Fi', 10, '$100');