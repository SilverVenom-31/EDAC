use humanresource;

--Q1 empid ,name, sal,manager, department



create or replace view empData
as

select E.employee_id, concat(E.first_name,' ',E.last_name) fullname , E.salary,concat(E2.first_name,' ',E2.last_name) manager, D.department_name 
from employees E
inner join departments D
on E.department_id = D.department_id
left join employees E2
on E.manager_id= E2.employee_id  ; 


--Q2 6000 < sal < 10000

create or replace view empSal
as

select * from employees where salary between 6000 and 10000;


--Q3 EMPLOYEEID,EMPLOYEENAME,EMPLOYEEDEPARTMENT,EMPLOYEESALARY,EMPLOYEECOUNTRY,EMPLOYEELOCATION,EMPLOYEEREGION

create or replace view employeeData
as
select E.employee_id , concat(E.first_name,' ',E.last_name) fullname, D.department_name, E.salary, C.country_name,L.city , R.region_name
from employees E
inner join departments D
on E.department_id = D.department_id
inner join locations L
on D.location_id = L.location_id
inner join countries C
on L.country_id = C.country_id 
inner join regions R
on C.region_id = R.region_id;


--Q4 
create or replace view deptSal
as 
 select * from employees where department_id = 30 and salary <10000 with check option;



--Q5
select E.first_name, E.salary, ((E.salary + (ifnull(E.commission_pct,0))) * 
(case 
when E.salary between 2000 and 10000 then 1.1
when E.salary between 10001 and 15000 then 1.08
when E.salary between 15001 and 20000 then 1.06
when E.salary > 20000 then 1.05 else 0 end)) as AppraiseSalary from employees E;


--Q6

 update empSal set salary = 9000.01 where employee_id  = 105;
 
 delete from empSal where employee_id = 106;
 
 update empSal set department_id = 10 where employee_id = 108;
 
 --Q7
 -- we can only modify those columns data which are part of view. 



