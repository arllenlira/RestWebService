delimiter $$

CREATE DATABASE `starterlab` /*!40100 DEFAULT CHARACTER SET latin1 */$$


CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `latitude` varchar(100) DEFAULT NULL,
  `longitude` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1$$

insert into city(name, latitude, longitude) values('MANAUS', '-3.1019400', '-60.0250000')$$
insert into city(name, latitude, longitude) values('RIO DE JANEIRO', '-22.9027800', '-43.2075000')$$
insert into city(name, latitude, longitude) values('BRASÍLIA', '-15.7797200', '-47.9297200')$$
insert into city(name, latitude, longitude) values('SÃO PAULO', '-23.5475000', '-46.6361100')$$
insert into city(name, latitude, longitude) values('PORTO ALEGRE', '-30.0330600', '-51.2300000')$$


