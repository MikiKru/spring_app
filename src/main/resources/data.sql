-- init-mode = always
truncate user_permission;
delete from user;
delete from permission;
-- default permission
insert into permission
values 	(1, "ROLE_USER"),
(2, "ROLE_ADMIN");
-- default user
insert into user
values 	(1, "test1@test.pl", 1 ,"Test111_", sysdate()),
(2, "test2@test.pl", 1 ,"Test222_", sysdate()),
(3, "test3@test.pl", 1 ,"Test333_", sysdate());
-- default access
insert into user_permission
values 	(1,1),(2,1),(3,1),(3,2);