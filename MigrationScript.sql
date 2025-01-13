-- Naming convention: Database name is capitalized while table names and attributes are written
-- in lower case. Table names are singular. For seperating words underscore is used. Reserved words
-- used for attriburte names go as follows CONCAT(LOWER(reserved_word), '_');
-- All primary keys are named 'id' and foregin keys go as follows 'CONCAT('table_name', '_id');
-- As for the dates, the name describes what the date represents. --

-- Creating Theatre database --
DROP DATABASE IF EXISTS Theatre;
CREATE DATABASE Theatre;
USE Theatre;

-- Creating tables --
CREATE TABLE performance (
	id INT NOT NULL AUTO_INCREMENT,
	status_ ENUM('consulting', 'planning', 'building', 'implementing') DEFAULT 'consulting',
    type_ ENUM('play', 'concert', 'opera', 'dance') DEFAULT 'play',
    description_ TEXT,
    date_time DATE,
    location VARCHAR(40),
    duration TIME,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE project (
    id INT NOT NULL AUTO_INCREMENT,
    name_ VARCHAR(50),
    type_ VARCHAR(50),
    status_ ENUM('planned', 'in_progrss', 'completed', 'canceled') DEFAULT 'planned',
    start_date DATETIME,
    description_ TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME,
    PRIMARY KEY (id)
);

CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(30),
    email VARCHAR(120),
    password_hash VARCHAR(64),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    status_ ENUM('active', 'inactive', 'suspended') DEFAULT 'active',
    specialization ENUM('actor', 'director', 'technician', 'stuff'),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME,
    PRIMARY KEY (id)
);

CREATE TABLE department (
    id INT NOT NULL AUTO_INCREMENT,
    employee_id int,
    name_ VARCHAR(50),
    category VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE location (
	id INT NOT NULL AUTO_INCREMENT,
    country VARCHAR(40),
    city VARCHAR(40),
    address VARCHAR(80),
    PRIMARY KEY (id)
);
