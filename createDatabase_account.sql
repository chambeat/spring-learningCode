create database spring;

use spring;

drop table if exists account;

create table account(
	`id` int primary key auto_increment,
    `name` varchar(40),
    `money` float
)character set utf8 collate utf8_general_ci;

insert into account(`name`,`money`) values('张三',1000);
insert into account(`name`,`money`) values('李四',2000);
insert into account(`name`,`money`) values('Ellen',8000);