CREATE USER 'hibernate'@'localhost' IDENTIFIED BY 'hibernate';

CREATE SCHEMA PUBLISH_HIBERNATEDB;
GRANT ALL PRIVILEGES ON PUBLISH_HIBERNATEDB.* TO 'hibernate'@'localhost';
FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+5:00';