use vhe;
delimiter //

drop procedure if exists q_get_all_accounts;

create procedure q_get_all_accounts()
begin
  select name,account_nr from vhe.account;
end //

delimiter ;;