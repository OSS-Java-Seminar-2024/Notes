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