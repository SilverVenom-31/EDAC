use humanresource;

		DELIMITER //
		drop procedure if exists test //

		CREATE PROCEDURE test() 
		 BEGIN
	      	 DECLARE  v_weight INT (3) DEFAULT 600;
		    DECLARE v_message VARCHAR(255) DEFAULT 'Product 10012';

	 	BEGIN
	      		DECLARE  v_weight INT(3) DEFAULT 1;
	      		DECLARE  v_message VARCHAR (25) DEFAULT 'Product 11001';
	      		DECLARE  v_new_locn VARCHAR(25) DEFAULT 'Europe';
	   		
	   		select v_message;
	    		SET v_weight = v_weight +1;
	    		select v_weight;
	  		
				--  Point 1
				select concat('Western',v_new_locn);

	END; 
	 SET v_weight=v_weight + 1;
	 select v_weight;
	 SET v_message=concat(v_message, ' is in stock');
	select v_message;
	select v_new_locn;
	-- Point 2

	   END; //

		DELIMITER ;
		
	
	---------------------------------------------------------------------------------------
	( first_Int/second_Int + second_Int)
		
			Delimiter //
			drop procedure if exists p1 //
			create procedure p1 (x int , y int) 
			begin 
			DECLARE z int ;
			
			if (x = 0 or y = 0) 
			then 
			
			select 'Enter non zero values';
			else 
			
			
			
			
			set z = (x/y) +y;
			select z;
			
			end if;
			
			end  //
			
			delimiter ;
			
		
	----------------------------------------------------------------------------------------
	
	
			Delimiter //
			drop procedure if exists p2 //
			create procedure p2 (x int ) 
			begin 
			declare max_sal,min_sal int;
			
			select max(salary) , min(salary) into max_sal,min_sal from employees where department_id =x;
			
			select max_sal,min_sal ;
			
			end //
	
			delimiter ; 
	
	
	
	-------------------------------------------------------------------------------------------
	Criteria for deciding salary class: 
    • If the salary is less than 10000, then it comes under the class 'LOW'
    • If the salary is greater than or equal to  10000 and less than 15000, then it comes under class 'MEDIUM'.
    • If the salary is greater than or equal to 15000, then it comes under class 'HIGH'

	
	
			Delimiter //
			drop procedure if exists p3 //
			create procedure p3 (x int)
			
			Begin
			
			declare status varchar(20);
			declare sal int;
			select  salary into sal from employees where employee_id = x;
			
			if sal > 15000  
			then 
				set status = 'High';
			elseif sal between 10000 and 15000
			then 	
				set status = 'Medium';
			else 
				set status = 'Low';
			end if;
			
			select sal , status;
			
			end //
			delimiter ;
			
--------------------------------------------------------------------------------------------------------===================----------

		
		delimiter //
		drop procedure if exists p4 //
		create procedure p4(x int)
		Begin
		
		
		case x
		when 1 then select 'January';
		when 2 then select 'February';
		when 3 then select 'March';
		when 4 then select 'April';
		when 5 then select 'May';
		when 6 then select 'June';
		when 7 then select 'July';
		when 8 then select 'August';
		when 9 then select 'September';
		when 10 then select 'October';
		when 11 then select 'November';
		when 12 then select 'December';
		else  select'Invalid month';
		
		end case;
		
		
		
		
		End //
		delimiter ;
			
			
			
-------------------------------------------------------------------------------------------------------------------------------
	
	
	
		delimiter //
		drop procedure if exists p5 //
		create procedure p5(x int)
		begin 
		declare id,deptid int;
		declare name,deptname varchar(30);
		
		
		select E.employee_id , concat(E.first_name,' ',E.last_name), D.department_id, D.department_name into id,name,deptid,deptname 
		from employees E inner join departments D
		on E.department_id = D.department_id 
		where E.employee_id = x;
		
		
		select name,deptname ;
		
		end //
		delimiter ;
		
		
	
	---------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	delimiter //
	drop procedure if exists p6 //
	create procedure p6 (x int )
	
	begin
		
	declare empid int;
	declare sal int;
	declare cnum int;
	
	
	
	
	declare emp_cur cursor for select employee_id , salary from employees where department_id = x;

	open emp_cur;
	
	select count(*) into cnum from employees where department_id = x;
	
	
		L_level : loop 
		
		if cnum <=0 
	then
	leave L_level;
	end if;
	
	
	
	fetch emp_cur into empid,sal;
	
	select empid, sal * 1.10 ;
	
	set cnum = cnum -1;
	end loop L_level;
	
	close emp_cur;
	end //
	delimiter ; 
	
	
	
	
	
------------------------------------------------------------------------------------------------------------------------------------------


		delimiter //
		drop procedure if exists p7 //
		create procedure p7()
		begin		
		declare empid int;
		declare sal int;
		declare num int default 5;
		declare finish int default 0;	
		DECLARE exit HANDLER for 1329 set finish = 1;
		declare emp_cur cursor for select employee_id , salary from employees limit 5;
		
		open emp_cur; 	
		
		L_level : loop 
		
		if (finish =1) then
		leave L_level;
		end if; 
		fetch emp_cur into empid, sal;
		select empid,sal;
		end loop L_level ;
		close emp_cur; 
		end //
		delimiter ;
		
	
	
	--===========================================================================================================================
	
	
	
	delimiter //
	drop procedure if exists p8 //
	create procedure p8()
	begin
		
		declare deptid,sal int;
		declare job varchar(10);
		declare c1 cursor for select job_id , salary , department_id from employees; 
		
		
		open c1;
		test : loop
		
		fetch c1 into job,sal,deptid;
		
		
		if ((job like '%CLERK%') and (deptid = 30)) then
		select sal *1.20,job;
		elseif ((job like '%MAN%') and (deptid = 50)) then
		select sal * 1.05,job;
		else select sal * 1.10,job;
		
		
		
		end if;
		
		end loop test;
		
		close c1;
		end //
		delimiter ;
		
	
	--------------------------------------------------------------------------------------------------------------------------------
	
	
		delimiter //
		drop procedure if exists p9 //
		create procedure p9(x float)
		 
		begin
		
		declare count int ;
		DECLARE exit handler for SQLEXCEPTION
		begin
		insert into messages(err_message) values ('Some other error occurred');
		end;
		
		select count(*) into count from employees where salary = x;
		
		
		if count = 1
		then
		insert into messages(err_message) values (concat('Only one employee with salary ',x,' employee name: ',(select concat 			( first_name, ' ' , last_name ) from employees where salary = x) ));
		
		elseif count >1
		then 
		
		insert into messages(err_message) values (concat('More than one employee with salary of ',x));
		elseif count = 0
		then
		insert into messages(err_message) values (concat('No employee with salary of ',x));
		
		else 
		select ' some other error';
		
		end if;
		
		
		end //
		delimiter ;
		
	
	--------------------------------------------------------------------------------------------------------------------------------
	
	
		
		delimiter //
		drop procedure if exists p10 //
		create procedure p10(x varchar(20))
		begin 
		
		declare continue handler for 1265	
		begin
		insert into messages(err_message) values ('Some other error occurred');
		end;
		
		call p9(x);
		
		end //
		delimiter ;
	
	
	
	------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
