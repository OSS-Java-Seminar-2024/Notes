-- Enable the Theatre database
CREATE DATABASE Theatre;
USE Theatre;

-- Create the Performances table with UUID as primary key
CREATE TABLE Performances (
    Performance_ID CHAR(36) PRIMARY KEY AUTO_INCREMENT,
    Project_ID CHAR(36) NOT NULL,
    Performance_Type VARCHAR(50),
    Performance_Status CHAR(36) NOT NULL, -- Links to Statuses table
    Date DATE NOT NULL,
    Start_Time TIME NOT NULL,
    Duration CHAR(10) CHECK (Duration REGEXP '^[0-9]{2}:[0-9]{2}$'),
    Location_ID CHAR(36) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,
    CONSTRAINT Unique_Performance UNIQUE (Date, Start_Time, Location_ID)
);

-- Create the Locations table with UUID as primary key
CREATE TABLE Locations (
    Location_ID CHAR(36) PRIMARY KEY AUTO_INCREMENT,
    Location_Name VARCHAR(50) NOT NULL,
    Status VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL
);

-- Create the Departments table with UUID as primary key
CREATE TABLE Departments (
    Department_ID CHAR(36) PRIMARY KEY AUTO_INCREMENT,
    Department_Name VARCHAR(50) NOT NULL,
    Category VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL
);

-- Create the Projects table with UUID as primary key
CREATE TABLE Projects (
    Project_ID CHAR(36) PRIMARY KEY AUTO_INCREMENT,
    Department_ID CHAR(36) NOT NULL,
    Project_Name VARCHAR(50) NOT NULL,
    Project_Type VARCHAR(50),
    Project_Status CHAR(36) NOT NULL, -- Links to Statuses table
    Start_Date DATE,
    Description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL
);

-- Create the Employees table with UUID as primary key
CREATE TABLE Employees (
    Employee_ID CHAR(36) PRIMARY KEY AUTO_INCREMENT,
    Department_ID CHAR(36) NOT NULL,
    First_Name VARCHAR(50) NOT NULL,
    Last_Name VARCHAR(50) NOT NULL,
    Status VARCHAR(50) DEFAULT 'Active',
    Specialization VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL
);

-- Create the Employee_on_Project table
CREATE TABLE Employee_on_Project (
    Employee_ID CHAR(36) NOT NULL,
    Project_ID CHAR(36) NOT NULL,
    PRIMARY KEY (Employee_ID, Project_ID)
);

-- Create the Statuses table with UUID as primary key
CREATE TABLE Statuses (
    Status_ID CHAR(36) PRIMARY KEY AUTO_INCREMENT,
    Status_Type VARCHAR(50), -- e.g., 'Performance', 'Project'
    Status_Name VARCHAR(50), -- e.g., 'Scheduled', 'Completed'
    Description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Add foreign keys
ALTER TABLE Performances 
    ADD CONSTRAINT FK_Performances_Locations FOREIGN KEY (Location_ID) REFERENCES Locations(Location_ID);

ALTER TABLE Performances 
    ADD CONSTRAINT FK_Performances_Projects FOREIGN KEY (Project_ID) REFERENCES Projects(Project_ID);

ALTER TABLE Performances 
    ADD CONSTRAINT FK_Performances_Status FOREIGN KEY (Performance_Status) REFERENCES Statuses(Status_ID);

ALTER TABLE Projects 
    ADD CONSTRAINT FK_Projects_Departments FOREIGN KEY (Department_ID) REFERENCES Departments(Department_ID);

ALTER TABLE Projects 
    ADD CONSTRAINT FK_Projects_Status FOREIGN KEY (Project_Status) REFERENCES Statuses(Status_ID);

ALTER TABLE Employees 
    ADD CONSTRAINT FK_Employees_Departments FOREIGN KEY (Department_ID) REFERENCES Departments(Department_ID);

ALTER TABLE Employee_on_Project 
    ADD CONSTRAINT FK_Employee_on_Project_Projects FOREIGN KEY (Project_ID) REFERENCES Projects(Project_ID);

ALTER TABLE Employee_on_Project 
    ADD CONSTRAINT FK_Employee_on_Project_Employees FOREIGN KEY (Employee_ID) REFERENCES Employees(Employee_ID);

-- Indexes for frequently queried fields
CREATE INDEX idx_performances_date_status ON Performances (Date, Performance_Status);
CREATE INDEX idx_projects_department ON Projects (Department_ID);

-- Optional: Controlled vocabulary for Specialization
CREATE TABLE Specializations (
    Specialization_ID CHAR(36) PRIMARY KEY AUTO_INCREMENT,
    Specialization_Name VARCHAR(50)
);

ALTER TABLE Employees 
    ADD Specialization_ID CHAR(36),
    ADD CONSTRAINT FK_Employees_Specializations FOREIGN KEY (Specialization_ID) REFERENCES Specializations(Specialization_ID);
