use vhe;
drop table if exists account ;

create table account(
id int not null,
name varchar(60) not null,
account_nr char(4) not null,
primary key (id)
) engine INNODB;