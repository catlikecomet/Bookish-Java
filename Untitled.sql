DROP DATABASE IF EXISTS Library;
CREATE DATABASE Library;
USE Library;


CREATE TABLE Books(
BookId int NOT NULL,
ISBN integer,
Title varchar(255),
Author varchar(255),
Descrip varchar(255),
Genre varchar(100),
PRIMARY KEY (BookId),
UNIQUE KEY BookId(BookId)
);

CREATE TABLE Copies(
BookId integer,
ISBN integer,
FOREIGN KEY (BookId) REFERENCES Books(BookId)
);

CREATE TABLE CheckInOut(
TransacId integer NOT NULL,
BookId integer,
UserId varchar(255),
OutDate date,
InDate date,
DueDate date,
PRIMARY KEY (TransacId),
FOREIGN KEY (BookId) REFERENCES Books(BookId),
FOREIGN KEY (UserId) REFERENCES Members(UserId)
);
CREATE TABLE Members(
UserId varchar(255) NOT NULL,
UserName varchar(255),
Pass varchar(255),
Named varchar(255),
TransacId integer,
PRIMARY KEY (UserId),
FOREIGN KEY (TransacId) REFERENCES CheckInOut(TransacId)
);

