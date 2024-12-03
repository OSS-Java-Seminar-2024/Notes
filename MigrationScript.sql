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
CREATE TABLE performances (
    id INT NOT NULL AUTO_INCREMENT,
    type_ VARCHAR(50),
    date_time DATE NOT NULL,
    duration CHAR(10) CHECK (duration REGEXP '^[0-9]{2}:[0-9]{2}$'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE locations (
    id int NOT NULL AUTO_INCREMENT,
    name_ VARCHAR(50) NOT NULL,
    status_ VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE departments (
    id int NOT NULL AUTO_INCREMENT,
    name_ VARCHAR(50) NOT NULL,
    category VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE projects (
    id INT NOT NULL AUTO_INCREMENT,
    department_id CHAR(40) NOT NULL,
    name_ VARCHAR(50) NOT NULL,
    type_ VARCHAR(50),
    status_ CHAR(40) NOT NULL,
    start_date DATE,
    description_ TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE employees (
    id INT NOT NULL AUTO_INCREMENT,
    department_id CHAR(40) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    status_ VARCHAR(50) DEFAULT 'Active',
    specialization VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE employee_on_project (
    employee_id INT NOT NULL,
    project_id INT NOT NULL,
    PRIMARY KEY (employee_id, project_id)
);

CREATE TABLE statuses (
    id INT NOT NULL AUTO_INCREMENT,
    type_ VARCHAR(50), -- e.g., 'Performance', 'Project'
    name_ VARCHAR(50), -- e.g., 'Scheduled', 'Completed'
    description_ TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

-- Adding foreign keys for table 'performances'
ALTER TABLE performances ADD COLUMN project_id INT NOT NULL DEFAULT 0;
ALTER TABLE performances
	ADD FOREIGN KEY (project_id) REFERENCES projects(id);
    
ALTER TABLE performances ADD COLUMN status_id INT NOT NULL DEFAULT 0;
ALTER TABLE performances
	ADD FOREIGN KEY (status_id) REFERENCES statuses(id);

ALTER TABLE performances ADD COLUMN location_id INT NOT NULL DEFAULT 0;
ALTER TABLE performances
	ADD FOREIGN KEY (location_id) REFERENCES locations(id);

-- Adding foreign keys for table 'performances'
ALTER TABLE projects ADD COLUMN status_id INT NOT NULL DEFAULT 0;
ALTER TABLE projects
	ADD FOREIGN KEY (status_id) REFERENCES locations(id);

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    