
DROP USER if exists 'spring'@'localhost' ;

CREATE USER 'spring'@'localhost' IDENTIFIED BY 'spring';

GRANT ALL PRIVILEGES ON * . * TO 'spring'@'localhost';
