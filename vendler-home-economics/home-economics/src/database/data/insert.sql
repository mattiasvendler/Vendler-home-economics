use vhe;
--MAT
insert ignore into account_group (id,name) values (100,"Mat");
insert ignore into account (id,name,account_nr) values (101,"Matvaror","101");
insert ignore into account (id,name,account_nr) values (102,"Lunch","102");
insert ignore into account (id,name,account_nr) values (103,"TakeAway","103");
insert ignore into account (id,name,account_nr) values (104,"Diverse","104");
insert ignore into account_group_accounts (account_id,account_group_id) values (101,100);
insert ignore into account_group_accounts (account_id,account_group_id) values (102,100);
insert ignore into account_group_accounts (account_id,account_group_id) values (103,100);
insert ignore into account_group_accounts (account_id,account_group_id) values (104,100);

--SHOPPING
insert ignore into account_group (id,name) values (200,"Shopping");
insert ignore into account (id,name,account_nr) values (201,"Kläder","201");
insert ignore into account (id,name,account_nr) values (202,"Presenter","202");
insert ignore into account (id,name,account_nr) values (203,"Diverse","203");
insert ignore into account_group_accounts (account_id,account_group_id) values (201,200);
insert ignore into account_group_accounts (account_id,account_group_id) values (202,200);
insert ignore into account_group_accounts (account_id,account_group_id) values (203,200);

--INKOMST
insert ignore into account_group (id,name) values (300,"Inkomst");
insert ignore into account (id,name,account_nr) values (301,"Lön","301");
insert ignore into account (id,name,account_nr) values (302,"Barnbidrag","302");
insert ignore into account (id,name,account_nr) values (303,"Försäkringskassan","303");
insert ignore into account (id,name,account_nr) values (304,"Diverse","304");
insert ignore into account_group_accounts (account_id,account_group_id) values (301,300);
insert ignore into account_group_accounts (account_id,account_group_id) values (302,300);
insert ignore into account_group_accounts (account_id,account_group_id) values (303,300);
insert ignore into account_group_accounts (account_id,account_group_id) values (304,300);

--LÅN
insert ignore into account_group (id,name) values (400,"Lån");
insert ignore into account (id,name,account_nr) values (401,"Hus lån","401");
insert ignore into account (id,name,account_nr) values (402,"CSN","402");
insert ignore into account (id,name,account_nr) values (403,"Diverse","403");
insert ignore into account_group_accounts (account_id,account_group_id) values (401,400);
insert ignore into account_group_accounts (account_id,account_group_id) values (402,400);
insert ignore into account_group_accounts (account_id,account_group_id) values (403,400);

--Boende
insert ignore into account_group (id,name) values (500,"Boende");
insert ignore into account (id,name,account_nr) values (501,"El","501");
insert ignore into account (id,name,account_nr) values (502,"Vatten","502");
insert ignore into account (id,name,account_nr) values (503,"Sopor","503");
insert ignore into account (id,name,account_nr) values (504,"Försäkring","504");
insert ignore into account (id,name,account_nr) values (505,"Barnomsorg","505");
insert ignore into account (id,name,account_nr) values (506,"Telefon","506");
insert ignore into account (id,name,account_nr) values (507,"Internet","507");
insert ignore into account (id,name,account_nr) values (508,"Diverse","508");
insert ignore into account_group_accounts (account_id,account_group_id) values (501,500);
insert ignore into account_group_accounts (account_id,account_group_id) values (502,500);
insert ignore into account_group_accounts (account_id,account_group_id) values (503,500);
insert ignore into account_group_accounts (account_id,account_group_id) values (504,500);
insert ignore into account_group_accounts (account_id,account_group_id) values (505,500);
insert ignore into account_group_accounts (account_id,account_group_id) values (506,500);
insert ignore into account_group_accounts (account_id,account_group_id) values (507,500);
insert ignore into account_group_accounts (account_id,account_group_id) values (508,500);

--TRANSPORT
insert ignore into account_group (id,name) values (600,"Transport");
insert ignore into account (id,name,account_nr) values (601,"Kommunalt","601");
insert ignore into account (id,name,account_nr) values (602,"Drivmedel","602");
insert ignore into account (id,name,account_nr) values (603,"Reparation bil","603");
insert ignore into account (id,name,account_nr) values (604,"Diverse","604");
insert ignore into account_group_accounts (account_id,account_group_id) values (601,600);
insert ignore into account_group_accounts (account_id,account_group_id) values (602,600);
insert ignore into account_group_accounts (account_id,account_group_id) values (603,600);
insert ignore into account_group_accounts (account_id,account_group_id) values (604,600);

--Sparande
insert ignore into account_group (id,name) values (700,"Sparande");
insert ignore into account (id,name,account_nr) values (701,"Sparkonto","701");
insert ignore into account (id,name,account_nr) values (702,"Pension","702");
insert ignore into account (id,name,account_nr) values (703,"Fonder","703");
insert ignore into account (id,name,account_nr) values (704,"Fonder","704");
insert ignore into account_group_accounts (account_id,account_group_id) values (701,700);
insert ignore into account_group_accounts (account_id,account_group_id) values (702,700);
insert ignore into account_group_accounts (account_id,account_group_id) values (703,700);
insert ignore into account_group_accounts (account_id,account_group_id) values (704,700);

--Diverse
insert ignore into account_group (id,name) values (800,"Diverse");
insert ignore into account (id,name,account_nr) values (801,"Medlemskap","801");
insert ignore into account (id,name,account_nr) values (802,"Diverse","802");
-- insert ignore into account (id,name,account_nr) values (803,"Fonder","803");
insert ignore into account_group_accounts (account_id,account_group_id) values (801,800);
insert ignore into account_group_accounts (account_id,account_group_id) values (802,800);
-- insert ignore into account_group_accounts (account_id,account_group_id) values (803,800);

