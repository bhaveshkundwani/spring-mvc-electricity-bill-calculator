DROP DATABASE IF EXISTS electricity_bill_db;

CREATE DATABASE electricity_bill_db;

USE electricity_bill_db;

CREATE TABLE personsdetails (
    id INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    serviceNumber VARCHAR(20) NOT NULL,
    consumedUnits INT NOT NULL,
    gender VARCHAR(10),
    PRIMARY KEY (id)
);

INSERT INTO personsdetails
(id, name, serviceNumber, consumedUnits, gender)
VALUES
(1, 'personA', '123-456', 250, 'Female'),
(2, 'personB', '246-468', 350, 'Male'),
(3, 'personC', '123-678', 150, 'Female'),
(4, 'personD', '246-789', 220, 'Male'),
(5, 'personE', '146-189', 500, 'Female');

SELECT * FROM personsdetails;