alter table tasks add active tinyint;
update tasks set active = 1