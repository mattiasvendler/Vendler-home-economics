use vhe;

insert into account (id,name,account_nr) values (1,"Matvaror","1111");
insert into account (id,name,account_nr) values (2,"Kläder","2222");
insert into account (id,name,account_nr) values (3,"Lön","3333");
insert into account (id,name,account_nr) values (4,"Lunch","1112");
insert into account (id,name,account_nr) values (5,"Hus lån","1112");
insert into account (id,name,account_nr) values (6,"Presenter","1112");
insert into account (id,name,account_nr) values (7,"CSN","1112");

insert into account_group (id,name) values (1,"Mat");
insert into account_group (id,name) values (2,"Shopping");
insert into account_group (id,name) values (3,"Inkomst");
insert into account_group (id,name) values (4,"Lån");

insert into account_group_accounts (account_id,account_group_id) values (4,1);
insert into account_group_accounts (account_id,account_group_id) values (1,1);
insert into account_group_accounts (account_id,account_group_id) values (2,2);
insert into account_group_accounts (account_id,account_group_id) values (3,3);
insert into account_group_accounts (account_id,account_group_id) values (6,2);
insert into account_group_accounts (account_id,account_group_id) values (5,4);
insert into account_group_accounts (account_id,account_group_id) values (7,4);