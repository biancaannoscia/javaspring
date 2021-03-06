CREATE TABLE BOOK (
       ID INT(11) NOT NULL AUTO_INCREMENT
     , CATEGORY_NAME VARCHAR(100) NOT NULL
     , ISBN VARCHAR(10) NOT NULL
     , TITLE VARCHAR(200) NOT NULL
     , PUBLISHER VARCHAR(100) NOT NULL
     , PRICE DECIMAL(4,2) NOT NULL
     , UNIQUE UQ_BOOK (CATEGORY_NAME, TITLE)
     , PRIMARY KEY (ID)
);


insert into book (category_name, isbn, title, price, publisher) values ('Romance', '1234567899', 'Romeo and Juliet', 11.11, 'Bianca');
insert into book (category_name, isbn, title, price, publisher) values ('Fantasy', '9393847564', 'Harry Potter: And the Sorcerer Stone', 33.33, 'Bianca');
insert into book (category_name, isbn, title, price, publisher) values ('Fantasy', '4847362937', 'Harry Potter: And the Deathly Hallows', 44.44, 'A Great Publisher');
insert into book (category_name, isbn, title, price, publisher) values ('Sci-Fi', '3839384736', 'Goose Girl', 55.55, 'A Great Publisher');
insert into book (category_name, isbn, title, price, publisher) values ('Sci-Fi', '2839382736', 'Sirens of Titan', 77.77, 'Boston');
insert into book (category_name, isbn, title, price, publisher) values ('Biography', '4902938293', 'Walt Disney Biography', 88.88, "University");
insert into book (category_name, isbn, title, price, publisher) values ('Travel', '1234567899', 'Map of China', 22.22, 'Harvard');
insert into book (category_name, isbn, title, price, publisher) values ('Holiday', '9393847564', 'Nutcracker', 99.99, 'Harvard');
insert into book (category_name, isbn, title, price, publisher) values ('Holiday', '4847362937', 'A Christmas Carol', 10.10, 'Harvard');
insert into book (category_name, isbn, title, price, publisher) values ('Sci-Fi', '3839384736', 'Star Wards', 12.12, 'Publishing Co');
insert into book (category_name, isbn, title, price, publisher) values ('Sci-Fi', '2839382736', 'Lord of the Rings', 13.13, 'Publishing Co');
insert into book (category_name, isbn, title, price, publisher) values ('Fiction', '4902938293', 'Animal Farm', 66.66, 'Admin');