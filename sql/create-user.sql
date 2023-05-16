-- Drop user first if they exist
DROP USER if exists 'spring'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'spring'@'localhost' IDENTIFIED BY 'spring';

GRANT ALL PRIVILEGES ON * . * TO 'spring'@'localhost';