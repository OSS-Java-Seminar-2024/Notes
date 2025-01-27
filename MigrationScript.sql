
-- Creating Theatre database --
drop database if exists Theatre;
create database Theatre;
use Theatre;

-- Creating table employee (user) --
create table user (
    id int not null auto_increment,
    username varchar(30) unique not null,
    email varchar(60) unique not null,
    mobile varchar(15) unique not null,
    password_hash varchar(64) not null,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    role varchar(10),
    status varchar(10),
    created_at datetime default current_timestamp,
    updated_at datetime default current_timestamp,
    deleted_at datetime,
    
    department_id int not null,
    project_id int not null,
    
    primary key (id)
);

-- Create table project --
create table project (
    id int not null auto_increment,
    name varchar(50) unique not null,
    type varchar(10),
    status varchar(10),
    start_date datetime,
    description text,
    created_at datetime default current_timestamp,
    updated_at datetime default current_timestamp,
    deleted_at datetime,
    
    primary key (id)
);

-- Create table performance --
create table performance (
	id int not null auto_increment,
    type varchar(10),
    description text,
    date_time date,
    duration time,
    created_at datetime default current_timestamp,
    updated_at datetime default current_timestamp,

    project_id int not null,
    location_id int not null,
    
	primary key (id)
);

-- Create table department --
create table department (
    id int not null auto_increment,
    name varchar(50) unique not null,
    category varchar(10),
    
    primary key (id)
);

-- Create table location --
create table location (
	id int not null auto_increment,
    country varchar(40) not null,
    city varchar(40) not null,
    address varchar(80) not null,
    
    primary key (id)
);

-- Add foreign keys --
alter table performance add foreign key (project_id) references project(id);
alter table performance add foreign key (location_id) references location(id);

alter table user add foreign key (project_id) references project(id);
alter table user add foreign key (department_id) references department(id);

