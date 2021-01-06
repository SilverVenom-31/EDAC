use humanresource;

select count(*) total_record from employees;

select salary,department_id from employees order by salary DESC,department_id;

SELECT employee_id,first_name,last_name,TIMESTAMPDIFF(year,hire_date, sysdate()) AS DateDiff from employees ;

SELECT employee_id,first_name,last_name,DATE_ADD(hire_date , interval 3 month) AS DateAdd from employees;

select date_add(curdate(),interval 15 day);

select curdate();

select distinct job_id from employees;

select * from employees where (hire_date < '1987-09-28') and (hire_date > '1981-12-03');

select CONCAT(UPPER(SUBSTR(first_name,1,1)),LOWER(SUBSTR(first_name,2,LENGTH(first_name)))) AS NAME from employees where first_name LIKE 'A%' or first_name LIKE 'J%' or first_name LIKE 'M%';

select first_name,last_name,department_id from employees where commission_pct is not NULL;

select employee_id, first_name,last_name,salary, salary* (salary*15/100) AS '15% Increased Salary' from employees;

select employee_id,first_name,last_name,manager_id from emp_details_view;

select job_id from employees where department_id = 10;

select location_id from departments where department_id =10;

select * from locations where location_id = 1700;

select E.job_id, D.location_id from employees E natural join departments D;

select department_id from employees where salary > (select avg(salary) from employees);

select first_name  from employees where length(first_name)>5 ;

select first_name,last_name from employees where first_name like 'J%' and first_name like '%S';

select * from employees where department_id not in(10,20,40);

select * from employees where job_id not in ('AC_MGR','AD_PRES','FI_MGR','MK_MAN','PU_MAN','SA_MAN','ST_MAN');

select * from employees where salary >10000;

select * from employees where commission_pct is null;

select * from employees where first_name like '_L%';

select max(salary) , min(salary) from employees;

select department_id from employees  group by department_id having count(employee_id) > 3;
