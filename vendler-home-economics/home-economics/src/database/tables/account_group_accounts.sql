use vhe;
drop table if exists account_group_accounts;
create table account_group_accounts(
account_id int not null,
account_group_id int not null,
primary key(account_id,account_group_id)
) engine INNODB default charset=latin1;