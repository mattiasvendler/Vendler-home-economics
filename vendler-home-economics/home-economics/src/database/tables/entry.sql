use vhe;

drop table if exists entry;

create table entry(
  id int not null AUTO_INCREMENT,
  text varchar(120) not null,
  account_id int not null,
  entry_date date not null,
   amount double default 0,
    primary key(id)
) engine INNODB;