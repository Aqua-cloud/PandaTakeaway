/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.21 : Database - takeout
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`takeout` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `takeout`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) NOT NULL,
  `balance` double(16,2) NOT NULL DEFAULT '0.00',
  `phone` varchar(16) NOT NULL,
  `address` varchar(45) NOT NULL,
  `password` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`id`,`username`,`balance`,`phone`,`address`,`password`) values (1,'zhangsan',140.00,'17734342635','广州','221353'),(2,'messi',800.00,'18823233436','Barcelona','123834'),(3,'库里',300.00,'17735364585','LA','165436'),(4,'纳达尔',2000.00,'19823236574','US','125463'),(22,'杨家承',99772.00,'18823234269','中国','123456'),(23,'C罗',200.00,'1214561','中国','112341'),(27,'詹姆斯',1000.00,'12553873','美国','153673'),(28,'小卡',2333.00,'242452514','美国','124244'),(30,'小王',0.00,'1214561','广州','123456'),(31,'jiaomei',10000.00,'15934345647','广州','123456');

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(40) DEFAULT NULL,
  `shop_id` int(11) NOT NULL,
  `price` double(16,2) NOT NULL,
  `limit_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `business_id` (`shop_id`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`shop_id`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`goods_name`,`shop_id`,`price`,`limit_num`) values (1,'可乐',1,6.00,2),(2,'汉堡',1,30.00,16),(3,'鸡翅',1,15.00,20),(4,'炒饭',2,33.00,20),(5,'拉面',3,25.00,20),(10,'奶茶',1,5.00,18),(11,'汉堡',2,25.00,20),(12,'薯条',2,10.00,20),(13,'可乐',2,7.00,20),(14,'麻辣火锅',4,100.00,9),(15,'鸳鸯锅',4,120.00,10),(16,'卡布奇诺',5,20.00,20),(17,'烤奶',5,10.00,20),(18,'益杯百香果',5,10.00,20),(19,'水果茶',5,10.00,20),(20,'云吞面',6,10.00,30),(21,'蒸饺',6,7.00,30),(22,'净云吞',6,7.00,30),(23,'披萨',3,40.00,19);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_time` datetime NOT NULL,
  `customer_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `total_cost` double(16,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`order_time`,`customer_id`,`goods_id`,`number`,`total_cost`) values (3,'2020-03-12 18:01:01',22,23,1,40.00),(7,'2020-03-12 21:33:32',1,2,2,60.00);

/*Table structure for table `shop` */

DROP TABLE IF EXISTS `shop`;

CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(40) NOT NULL,
  `turnover` double(16,2) NOT NULL DEFAULT '0.00',
  `phone` varchar(16) NOT NULL,
  `address` varchar(45) NOT NULL,
  `password` varchar(6) NOT NULL,
  `evaluation` varchar(4) DEFAULT '暂无评价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `shop` */

insert  into `shop`(`id`,`shop_name`,`turnover`,`phone`,`address`,`password`,`evaluation`) values (1,'肯德基',2082.00,'885800601','广州','1234','五星'),(2,'麦当劳',5000.00,'88500062','广州','1234','三星'),(3,'必胜客',1500.00,'88580069','北京','4321','五星'),(4,'海底捞',100.00,'15934345647','广州','123456','五星'),(5,'一盒糖',200.00,'1214561','广州','1234','四星'),(6,'沙县小吃',0.00,'17756473644','广州','2222','暂无评价');

/*Table structure for table `webmaster` */

DROP TABLE IF EXISTS `webmaster`;

CREATE TABLE `webmaster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `webmaster` */

insert  into `webmaster`(`id`,`username`,`password`) values (1,'小王','123456'),(3,'小美','123465');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
