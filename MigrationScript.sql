
-- Creating Theatre database --
drop database if exists Theatre;
create database Theatre;
use Theatre;

-- Creating table user --
create table user (
    id int not null auto_increment,
    first_name varchar(30) not null,
    last_name varchar(50) not null,
    username varchar(20) unique not null,
    email varchar(60) unique not null,
    password varchar(60) not null,
    status varchar(10),
    role varchar(10),
    
    joining_date datetime default current_timestamp,
    retiring_date datetime,
    
    department_id int,
    
    primary key (id)
);

-- Create table project --
create table project (
    id int not null auto_increment,
    name varchar(50) unique not null,
	status varchar(10),
    type varchar(10),
	description text,
    user_role varchar(10),

    start_date datetime default current_timestamp,
    completion_date datetime,
    
    primary key (id)
);

-- Create table performance --
create table performance (
	id int not null auto_increment,
    type varchar(10),
    description text,
    
    date_time_held datetime,
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
    description text,
    
    primary key (id)
);

-- Create table user_on_project --
create table user_on_project (    
    user_id int not null,
    project_id int not null,
    
    primary key (user_id, project_id)
);


-- Add foreign keys --
alter table performance add foreign key (project_id) references project(id);
alter table performance add foreign key (location_id) references location(id);

alter table user add foreign key (department_id) references department(id);

alter table user_on_project add foreign key (user_id) references user(id);
alter table user_on_project add foreign key (project_id) references project(id);



