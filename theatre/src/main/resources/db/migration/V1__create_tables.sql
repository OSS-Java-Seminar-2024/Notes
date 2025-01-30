

-- Creating table employee (user) --
create table employee (
    id int not null auto_increment,
    username varchar(30) unique not null,
    email varchar(60) unique not null,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    status varchar(10),
    joining_tade datetime default current_timestamp,
    retiring_date datetime,

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

