
-- Assignment 8.txt
use humanresource;

--Q1.
select E.last_name,E.department_id,D.department_name from employees E
inner join departments D 
on E.department_id = D.department_id ;


--Q2 .last name , job title, dept id, , dept name in toronto

select E.last_name,J.job_title,E.department_id , D.department_name from employees E
left join departments D
on E.department_id = D.department_id
left join locations L
on D.location_id = L.location_id
left join jobs J
on E.job_id = J.job_id
where L.city = 'Toronto';



--Q3 last_name, emp id, manager's last name, mgr id

select E.last_name, E.employee_id , M.last_name, M.manager_id from employees E
inner join employees M
on E.manager_id = M.employee_id;



--Q4
select E.last_name, E.employee_id , M.last_name, M.manager_id from employees E
left join employees M
on E.manager_id = M.employee_id
order by E.employee_id;


--Q5 last name, dept no.,

select distinct department_id ,last_name  from employees;

--Q7 full name , hire_date


select concat(first_name, ' ' , last_name) fullName, hire_date from employees where hire_date > (select hire_date from employees where last_name = 'Davies');

--Q8 last name, hire_date 


select last_name, hire_date from employees where department_id  = (select department_id from employees where last_name = 'Zlotkey')
having last_name != 'Zlotkey';

--Q9 emp id , last name more than avg salary;


select employee_id , last_name from employees where salary > (select round(avg(salary),2) from employees) order by salary;



--Q10 emp id , last name 

select employee_id , last_name from employees where department_id = any (select department_id from employees where last_name like '%u%' group by department_id);



--Q11 last_name , dept id ,job id  whose location id is 1700;


select last_name,department_id , job_id from employees where department_id = any (select department_id from departments where location_id = 1700);


--Q12 last name and salary under King;

select last_name ,salary from employees where manager_id = any (select employee_id from employees where last_name  = 'King');


--Q13 dept id , last name, job id in executive department;
 
 select department_id , last_name , job_id from employees where department_id = (select department_id from departments where department_name = 'Executive');



--Q14 emp_id , last name, salary  more than average salary department 'u';


select employee_id , last_name , salary  from employees where department_id = any (select department_id from employees where last_name like '%u%' group by department_id) and salary >(select round(avg(salary),2) from employees) ;




--------------------------------------------------------------------------------------------------------------------------------------
--Assignment 8 



--Q1. fullname more salary than 163;


select concat(first_name,' ',last_name) fullName from employees where salary > (select salary from employees where employee_id = 163);


--Q2. full name , salary, deptid , job_id 


 select concat(first_name,' ',last_name) fullName , salary, department_id, job_id from employees where job_id = (select job_id from employees where employee_id = 169);


--Q3. full name , salary, deptid

select concat(first_name,' ',last_name) fullName , salary, department_id from employees where department_id = any (select department_id from employees group by department_id)  having salary =any (select min(salary) from employees group by department_id ) ;



--Q4 empid, full name, 

select employee_id , concat(first_name,' ',last_name) fullName from employees where salary > (select avg(salary) from employees);



--Q5 fullname, empid, sal report to payam;

select concat(first_name,' ',last_name) fullName, employee_id ,salary from employees where manager_id = (select employee_id from employees where first_name = 'Payam');

--Q6 deptid, fullname, job, department name in finance department;

select concat(E.first_name,' ',E.last_name) fullName, J.job_title job , D.department_name from employees E
inner join departments D
on E.department_id = D.department_id 
inner join jobs J
on E.job_id = J.job_id
where 
E.department_id = (select X.department_id from departments X where X.department_name = 'Finance');



--Q7
 select * from employees where salary = 3000 and manager_id = 121;


--Q8

	select * from employees where employee_id in (134,159,183);

--Q9

select * from employees where salary between 1000 and 3000;

--Q10

select * from employees where salary between (select min(salary) from employees) and 6500;


--Q11

 select * from employees where department_id in (select department_id from employees  where manager_id not between 100 and 200 group by department_id);


--Q12

select * from employees order by salary DESC limit 1 offset 1;


--Q13

select concat(first_name,' ',last_name) fullName, hire_date from employees where department_id = (select department_id from employees where first_name = 'Clara') and first_name != 'Clara';



--Q14 empid , fullname,

select employee_id , concat(first_name,' ',last_name) fullName from employees where department_id in (select department_id from employees where first_name like '%T%' group by department_id) ;



--Q15 


select employee_id , concat(first_name,' ',last_name) fullName, salary  from employees where department_id in (select department_id from employees where first_name like '%J%' group by department_id) and salary > (select avg(salary) from employees);


--Q16 empid, fullname , job title 


select E.employee_id, concat(E.first_name,' ',E.last_name) fullName, J.job_title from employees E
inner join jobs J
on E.job_id = J.job_id 
where salary < any (select salary from employees where job_id = 'MK_MAN') ;

--Q18 empid, fullname , job title 


select E.employee_id, concat(E.first_name,' ',E.last_name) fullName, J.job_title from employees E
inner join jobs J
on E.job_id = J.job_id 
where salary < any (select salary from employees where job_id = 'MK_MAN') and E.job_id != 'MK_MAN';

--Q19 empid, fullname , job title 



select E.employee_id, concat(E.first_name,' ',E.last_name) fullName, J.job_title from employees E
inner join jobs J
on E.job_id = J.job_id 
where salary > all (select salary from employees where job_id = 'PU_MAN') and E.job_id != 'PU_MAN';

--Q20 empid, fullname , job title s

select avg(salary) from employees group by department_id;


	select E.employee_id, concat(E.first_name,' ',E.last_name) fullName, J.job_title from employees E
	inner join jobs J
	on E.job_id = J.job_id 
	where salary > any (select avg(salary) from employees group by department_id) ;



--Q21 full name, department name salary more than 8000

select concat(E.first_name,' ',E.last_name) fullName, D.department_name from employees E
inner join departments D
on E.department_id = D.department_id 
where salary > 8000;


--Q21  dept id, total salary

select department_id,sum(salary) from employees group by department_id having count(*);


--Q22 empid,full name,job id     ST_MAN = SALESMAN, IT_PROG = DEVELOPER;

select employee_id , concat(first_name,' ',last_name) fullName, case job_id when 'ST_MAN' then  'SALESMAN' when 'IT_PROG' then  'DEVELOPER' else job_id end jobID from employees;


--Q23 empid , full name, salary , salary status= h/l
	

select employee_id,concat(first_name,' ',last_name) fullName,salary, 
	case
	when salary < (select avg(salary) from employees)
	then 'Low'
	else 'High'
	end salaryStatus from employees;
	
	
--Q27

select E.employee_id, concat(E.first_name,' ',E.last_name) fullName, D.department_name , C.country_name from employees E
inner join departments D
on E.department_id = D.department_id 
inner join locations L
on D.location_id = L.location_id
inner join countries C
on L.country_id  = C.country_id
where C.country_name = 'United Kingdom';
 









 



------------------------------------------------------------------------------------------------------------------------------
--assign correlated;


select * from employees where department_id in (select department_id from employees group by department_id)  and salary < all (select avg(salary) from employees group by department_id ) ;















