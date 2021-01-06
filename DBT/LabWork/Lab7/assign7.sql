use humanresource;

select employees.first_name, employees.last_name , departments.department_id,departments.department_name from employees inner join departments
on employees.department_id = departments.department_id;

 select E.first_name,E.last_name,D.department_name,L.city,L.state_province from departments D inner join employees E   
     on D.department_id = E.department_id 
     inner join locations L 
     on D.location_id = L.location_id;
     
select employees.first_name, employees.last_name , departments.department_id,departments.department_name from employees inner join departments
on employees.department_id = departments.department_id where employees.department_id in (80,40);

 
 select E.first_name,E.last_name,D.department_name,L.city,L.state_province from departments D inner join employees E   
     on D.department_id = E.department_id 
     inner join locations L 
     on D.location_id = L.location_id where E.first_name like '%z%';
     
     
select employees.first_name, employees.last_name , departments.department_id,departments.department_name from employees right join departments
on employees.department_id = departments.department_id;


select first_name, last_name,salary from employees where salary <8000;

select E2.first_name as 'Employee name' , E1.first_name as 'Manager Name' from employees E1 inner join employees E2  on E1.employee_id = E2.manager_id;

select distinct department_name,city,state_province from emp_details_view ;

select employees.first_name, employees.last_name , departments.department_id,departments.department_name from employees left join departments
on employees.department_id = departments.department_id;

select E2.first_name as 'Employee name' , E1.first_name as 'Manager Name' from employees E1 right join employees E2  on E1.employee_id = E2.manager_id;


select department_id,first_name, last_name  from employees where last_name = 'Taylor';

select J.job_title, D.department_name,CONCAT(E.first_name,' ',E.last_name) as 'full name' from employees E inner join departments D  on E.department_id = D.department_id  inner join jobs J on E.job_id = J.job_id inner join job_history JH on E.employee_id = JH.employee_id  where JH.start_date >= '1993-01-01' and JH.end_date <= '1997-08-31';


select J.job_title,CONCAT(E.first_name,' ',E.last_name) as 'full name', (J.max_salary - E.salary) from employees E inner join jobs J on E.job_id = J.job_id;

select D.department_name ,avg(E.salary) as AvgSal from employees E  inner join departments D on E.department_id = D.department_id where E.commission_pct
is not null group by E.department_id ;

--------------------------------------------------------------------------
 select employees.salary from employees where department_id = 80;

 select E1.first_name, E1.salary - E2.salary from employees E1  inner join (select min(salary) from employees where department_id = 80;) E2 on E1.employee_id = E2.employee_id;
 
 select CONCAT(E.first_name,' ',E.last_name) , J.job_title , E.salary - (select min(salary) from employees where department_id = 80) from employees E 
 inner join jobs J 
 on E.job_id = J.job_id ;
 
 
 select C.country_name , L.city, D.department_name from locations L inner join countries C on L.country_id = C.country_id inner join departments D on L.location_id = D.location_id;
 
 
select E2.manager_id, CONCAT(E.first_name,' ',E.last_name), D.department_name from employees E  inner join departments D on E.department_id = D.department_id inner join employees E2  on E.employee_id = E2.employee_id;

select  J.job_title, avg(salary) from employees E  inner join jobs J on E.job_id = J.job_id group by E.job_id;

select  J.job_title, CONCAT(E.first_name,' ',E.last_name) from employees E  inner join jobs J on E.job_id = J.job_id where E.salary >=12000;




select  C.country_name , L.city,R.department_name from locations L
	inner join (select D.department_id,D.department_name , D.location_id from departments D 
			inner join (select department_id from employees 
							group by department_id 
								having count(*) > 2 ) X 
							on D.department_id = X.department_id) R 
								on L.location_id  = R.location_id
									inner join countries C
										on L.country_id = C.country_id ;
	



select  D.department_name ,CONCAT(E.first_name,' ',E.last_name),L.city from employees E 
 inner join departments D 
 on E.department_id = D.department_id 
 inner join locations L
 on D.location_id = L.location_id;



select JH.employee_id,J.job_title,datediff(JH.end_date,JH.start_date) datediff from job_history JH
inner join jobs J
on JH.job_id = J.job_id
where JH.department_id = 80;


select CONCAT(E.first_name,' ',E.last_name) fullName, E.salary , D.department_name from departments D
inner join employees E 
on D.department_id = E.department_id 
inner join locations L
on D.location_id = L.location_id 
where L.city = 'London';


select CONCAT(E.first_name,' ',E.last_name) fullName, J.job_title, JH.start_date,JH.end_date from employees E
inner join jobs J 
on E.job_id = J.job_id 
inner join job_history JH
on E.job_id = JH.job_id 
where E.commission_pct is null;


select D.department_name , count(*) employees from employees E 
inner join departments D
on E.department_id = D.department_id 
group by E.department_id having count(*) ; 


select X.empid , X.fullname, C.country_name from locations L 
inner join countries C 
on L.country_id = C.country_id
inner join (select E.employee_id empid, CONCAT(E.first_name,' ',E.last_name) fullname, D.location_id locid from employees E
		inner join departments D
		on E.department_id  = D.department_id ) X
on L.location_id = X.locid limit 5;








 


