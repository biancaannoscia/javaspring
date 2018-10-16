insert into category (name) values ('Romance');
insert into category (name) values ('Fantasy');
insert into category (name) values ('SciFi');
insert into category (name) values ('Biography');

insert into book (category_id, isbn, title, price) values (1, '1234567899', 'Romeo and Juliet', 11.11);
insert into book (category_id, isbn, title, price) values (2, '9393847564', 'Harry Potter: And the Sorcerer Stone', 33.33);
insert into book (category_id, isbn, title, price) values (2, '4847362937', 'Harry Potter: And the Deathly Hallows', 44.44);
insert into book (category_id, isbn, title, price) values (3, '3839384736', 'Goose Girl', 55.55);
insert into book (category_id, isbn, title, price) values (3, '2839382736', 'Sirens of Titan', 77.77);
insert into book (category_id, isbn, title, price) values (4, '4902938293', 'Walt Disney Biography', 88.88);

insert into author (first_name, last_name, description) values ("William", "Shakespeare", "A very lovely author");
insert into author (first_name, last_name, description) values ("J.K.", " Rowling", "Wrote the best booker ever!");
insert into author (first_name, last_name) values ("Shannon", "Hale");
insert into author (first_name, last_name) values ("Kurt", "Vonnegut");
insert into author (first_name, last_name) values ("Walt", "Disney");

insert into author_book (author_id, book_id) values (1, 1);
insert into author_book (author_id, book_id) values (2, 2);
insert into author_book (author_id, book_id) values (2, 3);
insert into author_book (author_id, book_id) values (3, 4);
insert into author_book (author_id, book_id) values (4, 5);
insert into author_book (author_id, book_id) values (5, 6);


select * from category;
select * from book;
select * from author;
select * from author_book;