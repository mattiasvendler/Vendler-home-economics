use vhe;

drop procedure if exists b_get_account;
delimiter //
create procedure b_get_account(in p_accountId int)
begin
    select id,name,account_nr from vhe.account where id=p_accountId limit 1;
end //

delimiter ;