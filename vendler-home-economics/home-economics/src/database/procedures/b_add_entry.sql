use vhe;

drop procedure if exists b_add_entry;

delimiter //
create procedure b_add_entry(in p_text varchar(120),in p_account_id int,in p_amount double,in p_date date)
begin
    insert into entry (text,account_id,entry_date,amount)
    values (p_text,p_account_id,p_date,p_amount);
end //

delimiter ;