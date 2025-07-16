SQl:


use employee_management_system;
create table department(id bigint auto_increment primary key, name varchar(100) not null unique);
create table employee(id bigint primary key auto_increment, first_name varchar(50), last_name varchar(50), email varchar(100) unique not null, salary decimal(10,2), department_id bigint, foreign key (department_id) references department(id));
show tables;
desc employee;
desc department;
-- Departments
INSERT INTO department (name) VALUES ('IT'), ('HR'), ('Finance');
-- Employees
INSERT INTO employee (first_name, last_name, email, salary, department_id)
VALUES 
('Alice', 'Brown', 'alice@example.com', 70000.00, 1),
(NULL, 'Smith', 'smith@example.com', 50000.00, 2),
('Charlie', NULL, 'charlie@example.com', NULL, 1),
('Bob', 'Reo', 'bob@example.com', 20000.00, NULL);
select * from department;
select * from employee;
