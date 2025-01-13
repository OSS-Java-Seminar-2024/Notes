
-- Creating tables --
CREATE TABLE performance (
	id INT NOT NULL AUTO_INCREMENT,
    project_id INT,
    location_id INT,
	status VARCHAR(10),
    type VARCHAR(10),
    description TEXT,
    date_time DATE,
    duration TIME,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE project (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    type VARCHAR(10),
    status VARCHAR(10),
    start_date DATETIME,
    description TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME,
    PRIMARY KEY (id)
);

CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT,
    department_id INT,
    project_id INT,
    username VARCHAR(30),
    email VARCHAR(60),
    password_hash VARCHAR(64),
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    status VARCHAR(10),
    specialization VARCHAR(10),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME,
    PRIMARY KEY (id)
);

CREATE TABLE location (
	id INT NOT NULL AUTO_INCREMENT,
    country VARCHAR(40),
    city VARCHAR(40),
    address VARCHAR(80),
    PRIMARY KEY (id)
);

CREATE TABLE department (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    category VARCHAR(50),
    PRIMARY KEY (id)
);