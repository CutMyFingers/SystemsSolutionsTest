/*** Create Test Database ***/
CREATE DATABASE test_db;


/*** Create User And Grand Privileges ***/
CREATE USER 'systems_user'@'localhost' IDENTIFIED BY 's0lut10nz';
GRANT ALL PRIVILEGES ON test_db.* TO 'systems_user'@'localhost';


USE test_db;

/*** Create Test Database ***/
CREATE TABLE IF NOT EXISTS equations
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  a DECIMAL(19, 4) NOT NULL,
  b DECIMAL(19, 4) NOT NULL,
  c DECIMAL(19, 4) NOT NULL,
  first_root DECIMAL(19, 4) NOT NULL,
  second_root DECIMAL(19, 4) NOT NULL,
  discriminant DECIMAL(19, 4) NOT NULL
);