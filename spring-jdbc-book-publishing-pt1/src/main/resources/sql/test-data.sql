insert into category (name) values ('Romance');
insert into category (name) values ('Religious');
insert into category (name) values ('Fantasy');
insert into category (name) values ('SciFi');
insert into category (name) values ('Biography');

insert into book (category_id, isbn, title, price) values (1, '1234567899', 'Romeo and Juliet', 11.11);
insert into book (category_id, isbn, title, price) values (2, '1937463528', 'The Holy Bible', 22.22);
insert into book (category_id, isbn, title, price) values (3, '9393847564', 'Harry Potter', 33.33);
insert into book (category_id, isbn, title, price) values (3, '4847362937', 'Lord of the Rings', 44.44);
insert into book (category_id, isbn, title, price) values (3, '3839384736', 'Goose Girl', 55.55);
insert into book (category_id, isbn, title, price) values (4, '3928472819', 'Star Wars', 66.66);
insert into book (category_id, isbn, title, price) values (4, '2839382736', 'Sirens of Titan', 77.77);
insert into book (category_id, isbn, title, price) values (5, '4902938293', 'Walt Disney', 88.88);

select * from category;
select * from book;