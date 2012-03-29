use vhe;
drop procedure if exists q_get_entry_by_entry_text;

delimiter //

create procedure q_get_entry_by_entry_text (in p_text varchar(120))
begin
  select
    a.id accountId,
    a.name,a.account_nr,
    aga.account_group_id groupId
  from vhe.entry e,
    vhe.account a,
    vhe.account_group_accounts aga
  where
    e.account_id=a.id and
    aga.account_id=a.id and
    e.text=p_text
    order by e.id desc;

end //
delimiter ;