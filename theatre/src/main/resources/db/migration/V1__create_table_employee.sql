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

ALTER TABLE employee ADD CONSTRAINT fk_department
    FOREIGN KEY (department_id) REFERENCES department(id);