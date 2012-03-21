use vhe;
drop table if exists account_group;

create table account_group(
  id int not null,
  name varchar(30) not null,
  primary key (id)
) engine INNODB default charset=latin1;