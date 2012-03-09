use vhe;

drop procedure if exists b_get_all_entries;

delimiter //
create procedure b_get_all_entries()
begin
    select a.id acc_id,
    a.name acc_name,
    a.account_nr acc_nr,
    e.amount amount,
    e.text text,
    e.entry_date date,
    e.id entry_id
    from vhe.account a, vhe.entry e
    where a.id=e.account_id order by date asc;
end //

delimiter ;