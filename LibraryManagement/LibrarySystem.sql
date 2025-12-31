use basicdb;
create table book(bookId int ,title varchar(50),author varchar (50),availableCopies int);
select * from book;
ALTER TABLE book
ADD PRIMARY KEY (bookId);
desc book;
truncate table book;
ALTER TABLE book
MODIFY bookId INT AUTO_INCREMENT ;

CREATE TABLE student (
    studentId INT PRIMARY KEY,
    name VARCHAR(100),
    issuedBookId INT
);

select * from student;
ALTER TABLE student
MODIFY studentId INT AUTO_INCREMENT ;
truncate table student;
desc student;
insert into student (name,issuedBookId) values('Piyush Dubey',null),('Satyavrat Dubey',null),('Aadarsh Shukla',null),('SuryaKumar Yadav',null),('Ankush Dubey',null),('Abhishek Yadav',null);

create table login(emailId varchar(50),password varchar(50));
insert into login values ("abc@gmail.com","abc123");