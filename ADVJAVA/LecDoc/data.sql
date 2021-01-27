create table my_emp (
empid int primary key auto_increment,
name varchar(20),
addr varchar(20),
salary double,
deptid varchar(10),join_date date);
insert into my_emp  values(default,'rama','pune',15000,'rnd','2015-11-18');
insert into my_emp  values(default,'shekhar','mumbai',18000,'rnd','2015-1-18');
insert into my_emp  values(default,'kiran','pune',13000,'prod','2016-7-8');
insert into my_emp  values(default,'riya','delhi',25000,'rnd','2015-3-18');
insert into my_emp  values(default,'meeta','chennai',21000,'prod','2017-11-18');
