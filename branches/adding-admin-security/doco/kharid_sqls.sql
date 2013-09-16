CREATE USER 'mykharidvpsdb'@'localhost' IDENTIFIED BY 'livevpss3cretdb';

create database if not exists `kharid`;

GRANT ALL PRIVILEGES ON kharid.* TO 'mykharidvpsdb'@'localhost'  WITH GRANT OPTION;

USE `kharid`;

SET character_set_client = utf8;


DROP TABLE IF EXISTS `kharid`.`INQUIRY`;
CREATE TABLE  `kharid`.`INQUIRY` (
  `NAME` varchar(20) default NULL,
  `EMAIL` varchar(30) default NULL,
  `MESSAGE` varchar(1024) default NULL,
  `ID` int(11) NOT NULL auto_increment,
  `TYPE` varchar(10) default NULL,
  `DATE_MODIFIED` date default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `kharid`.`CONSTANTS`;
CREATE TABLE  `kharid`.`CONSTANTS` (
  	`ID` int(5) NOT NULL auto_increment,
	`CODE` varchar(30) default NULL,
  	`VAL` int(5) default NULL,
  	PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO `CONSTANTS` values 
	(1,'ROUND_UP_TO_LIMIT',500),
	(2,'AUD_MASTER_CC_LIMIT',1000),
	(3,'CC_POSTAGE_FEE_AUD',6),
	(4,'TO_IRR_RATE_MARGIN_RIAL',200);

DROP TABLE IF EXISTS `kharid`.`PRICE`;
CREATE TABLE  `kharid`.`PRICE` (
  `WEIGHT_BRACKET` varchar(20) default NULL,
  `POST_TYPE` varchar(3) default NULL,
  `PRICE` varchar(5) default NULL,
  `ID` int(4) NOT NULL auto_increment,
  `PACKAGE_TYPE` varchar(6) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


INSERT INTO `PRICE` VALUES 

('_0to50_Letter','AIR','2.2',100,'Letter'),
('_0to50_Letter','REG','20',101,'Letter'),
('_0to50_Letter','EPI','19',102,'Letter'),
('_0to50_Letter','ECI','43',103,'Letter'),

('_50to125_Letter','AIR','4.3',104,'Letter'),
('_50to125_Letter','REG','20',105,'Letter'),
('_50to125_Letter','EPI','19',106,'Letter'),
('_50to125_Letter','ECI','43',107,'Letter'),

('_125to250_Letter','AIR','6.5',108,'Letter'),
('_125to250_Letter','REG','20',109,'Letter'),
('_125to250_Letter','EPI','19',110,'Letter'),
('_125to250_Letter','ECI','43',111,'Letter'),

('_250to500_Letter','AIR','13.1',112,'Letter'),
('_250to500_Letter','REG','20',113,'Letter'),
('_250to500_Letter','EPI','19',114,'Letter'),
('_250to500_Letter','ECI','43',115,'Letter'),

('_0to250_Parcel','AIR','10',1,'Parcel'),
('_0to250_Parcel','ECI','42',10,'Parcel'),
('_0to250_Parcel','EPI','58',19,'Parcel'),
('_0to250_Parcel','REG','21.1',28,'Parcel'),
('_0to250_Parcel','SEA','7.05',37,'Parcel'),


('_250to500_Parcel','AIR','16',2,'Parcel'),
('_250to500_Parcel','ECI','42',11,'Parcel'),
('_250to500_Parcel','EPI','58',20,'Parcel'),
('_250to500_Parcel','REG','21.1',29,'Parcel'),
('_250to500_Parcel','SEA','11.2',38,'Parcel'),

('_500to750_Parcel','AIR','22',3,'Parcel'),
('_500to750_Parcel','ECI','51',12,'Parcel'),
('_500to750_Parcel','EPI','58',21,'Parcel'),
('_500to750_Parcel','REG','27.25',30,'Parcel'),
('_500to750_Parcel','SEA','15.35',39,'Parcel'),

('_750to1000_Parcel','AIR','28',4,'Parcel'),
('_750to1000_Parcel','EPI','58',22,'Parcel'),
('_750to1000_Parcel','ECI','51',13,'Parcel'),
('_750to1000_Parcel','REG','33.4',31,'Parcel'),
('_750to1000_Parcel','SEA','19.5',40,'Parcel'),

('_1000to1250_Parcel','AIR','34.15',5,'Parcel'),
('_1000to1250_Parcel','EPI','58',23,'Parcel'),
('_1000to1250_Parcel','ECI','64',14,'Parcel'),
('_1000to1250_Parcel','REG','39.55',32,'Parcel'),
('_1000to1250_Parcel','SEA','23.65',41,'Parcel'),


('_1250to1500_Parcel','AIR','40.3',6,'Parcel'),
('_1250to1500_Parcel','ECI','64',15,'Parcel'),
('_1250to1500_Parcel','EPI','58',24,'Parcel'),
('_1250to1500_Parcel','REG','45.7',33,'Parcel'),
('_1250to1500_Parcel','SEA','27.8',42,'Parcel'),


('_1500to1750_Parcel','AIR','46.45',7,'Parcel'),
('_1500to1750_Parcel','ECI','64',16,'Parcel'),
('_1500to1750_Parcel','EPI','58',25,'Parcel'),
('_1500to1750_Parcel','REG','51.85',34,'Parcel'),
('_1500to1750_Parcel','SEA','31.95',43,'Parcel'),

('_1750to2000_Parcel','AIR','52.6',8,'Parcel'),
('_1750to2000_Parcel','ECI','64',17,'Parcel'),
('_1750to2000_Parcel','EPI','58',26,'Parcel'),
('_1750to2000_Parcel','REG','58',35,'Parcel'),
('_1750to2000_Parcel','SEA','36.1',44,'Parcel'),

('_2000to2500_Parcel','AIR','60.05',9,'Parcel'),
('_2000to2500_Parcel','ECI','82',18,'Parcel'),
('_2000to2500_Parcel','EPI','72.9',27,'Parcel'),
('_2000to2500_Parcel','SEA','40.3',45,'Parcel'),

('_2500to3000_Parcel','AIR','67.50',200,'Parcel'),
('_2500to3000_Parcel','ECI','92.25',201,'Parcel'),
('_2500to3000_Parcel','EPI','72.9',202,'Parcel'),
('_2500to3000_Parcel','SEA','44.5',203,'Parcel');
