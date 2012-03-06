use vhe;

drop procedure if exists b_get_account_groups;

delimiter //
create procedure b_get_account_groups(in p_id int)
begin
  if p_id is null then
    select id,name from vhe.account_group;
    else
       select id,name from vhe.account_group where id = p_id;
    end if;
end //

delimiter ;