

use humanresource;
delimiter //
drop procedure if exists p12 //
create procedure p12(x varchar (20))
begin

declare count int ;
select count(*) into count from information_schema.table_constraints where table_name like x;


if count >0 then
select 'tables has constraint';
else select 'table does not have constraint';
end if;

end //
delimiter ;

-- ------------------------------------------
create table test2
(
id int,
name varchar(20)
);

insert into test values (2,'hello friend');
insert into test2 values ( 3, 'hello');


select * from test;

-- ------------------------------------------------------------

      Delimiter //
      Drop procedure  if exists get_missing_constraints //
      Create procedure get_missing_constraints()
      Begin
      SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'humanresource' 
      and lower(table_name) not in (SELECT DISTINCT TABLE_NAME FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS 
      WHERE  TABLE_SCHEMA =  'humanresource');
      End //
      Delimiter ;
	

      
      
      -- --------------------============================================================================
      call get_missing_constraints();
      
      
      -- =============================================================================================
      
      create table emp_bk like employees;
      
      create table emp_backup as select * from employees;
      
      
      -- =========================================================================================
      
      delimiter //
      drop procedure if exists p13 //
      create procedure p13(empid int, name varchar(20))
      begin
      
      
      if empid is null 
		then
			insert into emp_bk select * from employee_bk where first_name = name;
            delete from employee_bk where first_name = name;
            
	else
    delete from emplyee_bk where employee_id = empid;
    end if;
      end //
      delimiter ;
      
      
-- =====================================================================================================
		desc employees;
        select * from employees ;
		select max(salary) from employees where department_id = deptid;


		delimiter //
        drop procedure if exists p14 //
        create procedure p14(empid int unsigned , fname varchar(20),lname varchar(20),email varchar(20),pnum varchar(20), hdate date, 
							jobid varchar(10), sal decimal(8,2),comm decimal(2,2), mgrid int unsigned , deptid int unsigned)
                            begin
                            declare maxSal int;
                            select max(salary) into maxSal from employees where department_id = deptid;
                            
                            if sal is null then
								
                                update employees set salary = maxSal where employee_id = empid;
                            elseif comm is null then
								update employees set commission_pct = 0.20 where employee_id = empid;
                            end if;
                            
                            insert into employees values (empid,fname,lname,email,pnum,hdate,
															jobid,sal,comm,mgrid,deptid);
						
                            end //
                            delimiter ;
      
      
      
      -- =======================================================================================================
    
      
		delimiter //
        drop procedure if exists p15 //
        create procedure p15(p_salary_fix boolean )
        begin 
        declare deptid , sal int ;
        declare finish int default 0;
        declare result cursor for select department_id, avg(salary) from employee_bk group by department_id;
        declare exit handler for 1329 set finish =1;
        open result;
        
        level : loop
        if finish =1 then
        leave level;
        end if;
        fetch result into deptid,sal;
        
        
        if p_salary_fix then 
        update employee_bk set salary = (sal+100) where employee_id in (select x.employee_id from (select * from employee_bk) x where 		x.department_id = deptid and x.salary < sal);
        else
        select * from employee_bk where department_id = deptid and salary < sal;
        end if;
        
        end loop level;
        close result;
        end //
        delimiter ;
        
      
      
      
      call p15();
-- ================================================================================================================      
      
      
      delimiter //
      drop function if exists emp_incentive //
	  create function emp_incentive(empId int ) returns int
      begin
      
      declare sal,deptId ,avgSal int;
      
      select salary into sal from employees where employee_id = empId;
	select department_id into deptId from employees where employee_id = empId;
      select avg(salary) into avgSal from employees where department_id = deptId;
      
      if sal < avgSal then
		set sal = sal * 1.10;
	  else 
		set sal = sal;
	  end if;
      return sal;
      end //
      delimiter ;
      
      
      
      
      
