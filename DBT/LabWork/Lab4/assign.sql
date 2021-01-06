use humanresource;

select * from employees;

select * from employees where department_id = 10;

select * from employees where not department_id = 30;

select * from employees limit 5;

select * from employees where hire_date like '1987%';

select ifnull(commission_pct,0) from employees;

select manager_id,salary from employees where (manager_id in (124,100)) AND salary > 3000;

select * from employees where hire_date < '1996-08-31';

select * from employees where not hire_date like '1987%';

select hire_date from employees where month(hire_date) between 7 and 9;

select hire_date from employees limit 10;
 
select * from employees where salary <24000;

select employee_id,last_name,job_id,hire_date startDate from employees;

select distinct job_id from employees;

select last_name,job_id,hire_date from employees where last_name in ('Matos','Taylor') order by hire_date;

select * from employees where last_name like '__a%';

select last_name,hire_date from employees where hire_date like '1994%';

select * from employees where (last_name like '%a') or (last_name like '%e');
 
select last_name,department_id from employees where department_id in (20,50) order by last_name ;
 
select sysdate() AS date;
 
update employees set email ='not available';
 
update employees set email = 'organization@gmail.com', commission_pct = 0.20 where department_id = 20;
 
update employees set email = 'not available' where department_id in (80)  and commission_pct < 0.20;
 
UPDATE employees SET salary= CASE WHEN salary < 5000 THEN 8000 ELSE salary  END;

UPDATE employees SET job_id= CASE WHEN (department_id= 30) and (job_id not like 'SH%')  THEN 'SH_CLERK' ELSE job_id  END where employee_id = 118;

 
 




