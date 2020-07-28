use spring;

CREATE TABLE `account` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(40),
  `money` float
) character set utf8 collate utf8_general_ci;

insert into account(`name`,`money`) values('aaa',1000);
insert into account(`name`,`money`) values('bbb',1000);
insert into account(`name`,`money`) values('ccc',1000);










/*
CREATE TABLE `account` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `aname` varchar(40) DEFAULT NULL,
  `money` float DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
*/

