use vhe;

drop procedure if exists b_get_accounts_accountgroup;

delimiter //

create procedure b_get_accounts_accountgroup(in p_group_id int)
begin
    select a.id,a.name,a.account_nr
    from vhe.account a,vhe.account_group_accounts aga
    where a.id=aga.account_id and
          aga.account_group_id = p_group_id;
end //

delimiter ;