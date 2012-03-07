use vhe;

drop procedure if exists b_get_account;
delimiter //
create procedure b_get_account(in p_accountNr varchar(4))
begin
    select id,name,account_nr from vhe.account where account_nr=p_accountNr limit 1;
end //

delimiter ;