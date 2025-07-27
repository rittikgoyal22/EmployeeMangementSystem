SQL: 

    use employee_management_system; 
    create table department(id bigint auto_increment primary key, name varchar(100) not null unique); 
    
    CREATE TABLE employee (
        id BIGINT PRIMARY KEY AUTO_INCREMENT,
        first_name VARCHAR(50),
        last_name VARCHAR(50),
        email VARCHAR(100) UNIQUE NOT NULL,
        salary DECIMAL(10,2),
        department_id BIGINT,
        password VARCHAR(100) NOT NULL,
        FOREIGN KEY (department_id) REFERENCES department(id)
    );
    
    show tables; 
    desc employee; 
    desc department;
    INSERT INTO department (name) VALUES ('IT'), ('HR'), ('Finance'); 
    INSERT INTO employee (first_name, last_name, email, salary, department_id, password) VALUES
    ('Rittik', 'Goyal', 'rittikgoyal22@gmail.com', 200000.00, 1, 'rittik'),
    ('Garvit', 'Rangi', 'garvit@gmail.com', 100000.00, 2, 'garvit'),
    ('Mehul', 'Singh', 'mehul@gmail.com', 100000.00, 1, 'mehul'),
    ('Rishi', 'Raj', 'rishi@gmail.com', 200000.00, 3, 'rishi'),
    ('Saurabh', 'Singh', 'saurabh@gmail.com', 235211.00, 2, 'saurabh');
     select * from department; 
     select * from employee; 
   
