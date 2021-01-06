use humanresource;

select first_name as 'First Name', last_name as 'Last Name' from employees ;

select distinct department_id from employees;

select * from employees order by first_name DESC;

select first_name,last_name,salary, salary + salary* 15/100 as PF from employees;

select employee_id,first_name,last_name,salary from employees order by salary DESC;

select sum(salary) from employees;

select max(salary),min(salary) from employees;

select avg(salary),count(*) from employees ;

select count(*) from employees;

select count(distinct job_id ) from employees;
 
select UPPER(first_name) from employees;

select substr(first_name,1,3) from employees;

select 171*214+625 AS calculation; 

select first_name, last_name from employees where first_name in ('Ellen','Sundar') and last_name in ('Abel', 'Ande');

select trim(first_name) from employees;

select first_name,length(first_name),last_name,length(last_name) from employees;

select * from employees where first_name regexp '[0-9]';

select * from employees limit 10;

select truncate(salary/12,2) from employees ;

