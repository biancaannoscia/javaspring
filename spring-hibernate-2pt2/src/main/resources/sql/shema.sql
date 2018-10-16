CREATE TABLE CATEGORY (
       ID INT(11) NOT NULL AUTO_INCREMENT
     , NAME VARCHAR(100) NOT NULL
     , UNIQUE UQ_NAME (NAME)
     , PRIMARY KEY (ID)
);

CREATE TABLE BOOK (
       ID INT(11) NOT NULL AUTO_INCREMENT
     , CATEGORY_ID INT(11) NOT NULL
     , ISBN VARCHAR(10) NOT NULL
     , TITLE VARCHAR(500) NOT NULL
     , PRICE DECIMAL(4,2) NOT NULL
     , UNIQUE UQ_BOOK (CATEGORY_ID, TITLE)
     , PRIMARY KEY (ID)
     , CONSTRAINT FK_BOOK FOREIGN KEY (CATEGORY_ID)
                  REFERENCES CATEGORY (ID)
);

CREATE TABLE AUTHOR (
       ID INT(11) NOT NULL AUTO_INCREMENT
     , FIRST_NAME VARCHAR(60) NOT NULL
     , LAST_NAME VARCHAR(60) NOT NULL
     , DESCRIPTION VARCHAR(1200)
     , UNIQUE UQ_AUTHOR (FIRST_NAME, LAST_NAME)
     , PRIMARY KEY (ID)
);


CREATE TABLE AUTHOR_BOOK (
    book_id INT(11) NOT NULL
     , author_id INT(11) NOT NULL
     , PRIMARY KEY (book_id, author_id)
     , CONSTRAINT FK_AUTHOR_BOOK_1 FOREIGN KEY (book_id)
         REFERENCES BOOK (ID) ON DELETE CASCADE
     , CONSTRAINT FK_AUTHOR_BOOK_2 FOREIGN KEY (author_id)
     REFERENCES AUTHOR (ID)
);
