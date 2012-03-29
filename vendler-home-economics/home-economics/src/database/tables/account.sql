use vhe;
drop table if exists account ;

create table account(
id int not null,
name varchar(60) not null,
account_nr char(4) not null unique ,
primary key (id)
) engine INNODB default charset=latin1;