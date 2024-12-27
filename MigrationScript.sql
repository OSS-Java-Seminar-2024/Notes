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
    status_ INT NOT NULL,
    location_id INT NOT NULL,
    project_id INT NOT NULL,
    type_ VARCHAR(50),
    description_ TEXT,
    date_time DATE NOT NULL,
    duration TIME,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

CREATE TABLE project (
    id INT NOT NULL AUTO_INCREMENT,
    name_ VARCHAR(50) NOT NULL,
    type_ VARCHAR(50),
    status_ INT NOT NULL,
    start_date DATE,
    description_ TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE employee (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    email VARCHAR(120) NOT NULL,
    password_hash VARCHAR(64),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
	department_id INT,
    status_ ENUM('active', 'retired', 'busy', 'unavailable') DEFAULT 'active',
    specialization ENUM('director', 'producer', 'composer', 'choreographer',
    'musician', 'stage manager', 'head of light', 'stage crew'),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at DATETIME NULL DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE statuse (
    id INT NOT NULL AUTO_INCREMENT,
    type_ ENUM('consulting', 'planning', 'building', 'implementing') DEFAULT 'consulting',
    description_ TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE employee_on_project (
    employee_id INT NOT NULL,
    project_id INT NOT NULL,
    FOREIGN KEY fk_project (project_id) REFERENCES project(id),
    FOREIGN KEY fk_employee (employee_id) REFERENCES employee(id),
    PRIMARY KEY (employee_id, project_id)
);

CREATE TABLE location (
    id INT NOT NULL AUTO_INCREMENT,
    name_ VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE department (
    id INT AUTO_INCREMENT,
    name_ VARCHAR(50) NOT NULL,
    category VARCHAR(50),
    PRIMARY KEY (id)
);

-- Adding foreign keys for table 'performances'
ALTER TABLE performance ADD CONSTRAINT fk_project
 FOREIGN KEY (project_id) REFERENCES project(id);
    
ALTER TABLE performance ADD CONSTRAINT fk_performance_status
	FOREIGN KEY (status_) REFERENCES statuse(id);

ALTER TABLE performance ADD CONSTRAINT fk_location
	FOREIGN KEY (location_id) REFERENCES location(id);
    
-- Adding foreign keys for table 'employees'
ALTER TABLE employee ADD CONSTRAINT fk_department
    FOREIGN KEY (department_id) REFERENCES department(id);

-- Adding foreign keys for table 'projects'
ALTER TABLE project ADD CONSTRAINT fk_project_status
	FOREIGN KEY (status_) REFERENCES statuse(id);