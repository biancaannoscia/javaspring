CREATE USER 'hibernate'@'localhost' IDENTIFIED BY 'hibernate';

CREATE SCHEMA BOOKDB;
GRANT ALL PRIVILEGES ON BOOKDB.* TO 'hibernate'@'localhost';
FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+5:00';