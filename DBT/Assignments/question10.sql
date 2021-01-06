

--> Q10.

Create the procedure to insert and update the record in the employee table and whenever
there is any update, create the logs for the same keeping old value and new value, date, and
user name.

insert into emp_bk(employee_id,first_name,last_name,email,phone_number,hire_date,job_id,salary,commission_pct,manager_id,department_id) values(801,"Initial","Test","test@gmail.com","938393493","2020-11-17","ST_CLERK",14000,null,100,10);


use humanresource;

delimiter // 
drop procedure if exists insertUpdate // 
create procedure insertUpdate(operation varchar(20), employeeId int, firstName varchar(20), lastName varchar(20), sal int) 
begin
   case
      lower(operation) 
      when
         "insert" 
      then
         select
            "insert operation" as operation;
insert into
   employees(employee_id, first_name, last_name, salary) 
values
   (
      employeeId,
      firstName,
      lastName,
      sal
   );
when
   "update" 
   then
      select "update operation" as operation;
update
   employees 
set
   salary = sal
where
   employee_id = employeeId;
else
   select
      "invalid operation";
   end case;
   end// 
   delimiter ;










-- ---------------------------------------------------------

create table updateLogs(
logId int auto_increment primary key,
userName varchar(50) not null unique,
logDate datetime default now(),
oldValue varchar(20),
newValue varchar(20)
);

delimiter //
drop trigger if exists updateLogs // 
create trigger updateLogs after 
update
   on employees for each row 
   begin
      insert into
         updateLogs(userName, logDate, oldValue, newValue) 
      values
         (
            concat(new.first_name, " ", new.last_name), curdate(), old.salary, new.salary
         );
   end// 
   delimiter ;



===================================================




