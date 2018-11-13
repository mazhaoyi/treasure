CREATE TABLE `ticket` (
  `ticket_id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_no` varchar(3) NOT NULL COMMENT '期数',
  `ticket_num` varchar(5) NOT NULL COMMENT '号码',
  `ticket_date` date NOT NULL COMMENT '日期',
  `bef3_max_count` tinyint(1) NOT NULL COMMENT '前三最大相同数',
  `mid3_max_count` tinyint(1) NOT NULL COMMENT '中三最大相同数',
  `aft3_max_count` tinyint(1) NOT NULL COMMENT '后三最大相同数',
  `max_count` tinyint(1) NOT NULL COMMENT '相同最大数',
  `line` tinyint(1) NOT NULL COMMENT '第几行',
  PRIMARY KEY (`ticket_id`),
  UNIQUE KEY `U_TNO_TDATE` (`ticket_no`,`ticket_date`) USING BTREE COMMENT '日期和期数唯一索引'
) ENGINE=InnoDB AUTO_INCREMENT=76618 DEFAULT CHARSET=utf8 COMMENT='票';

-- 这个可以先不要
CREATE TABLE `buy` (
  `buy_id` int(11) NOT NULL AUTO_INCREMENT,
  `start_no` smallint(3) NOT NULL COMMENT '开始序号',
  `end_no` smallint(3) NOT NULL COMMENT '结束序号',
  `ticket_date` date NOT NULL COMMENT '票时间',
  `end_flag` tinyint(1) NOT NULL COMMENT '1-未结束，2-结束',
  `user_id` int(11) NOT NULL COMMENT '关联用户ID',
  PRIMARY KEY (`buy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 这个可以先不要
CREATE TABLE `bz` (
  `bz_id` int(11) NOT NULL AUTO_INCREMENT,
  `bz_date` date NOT NULL COMMENT '日期',
  `bsg` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '后三豹子',
  `qbg` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '千百个豹子',
  `qbs` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '中三豹子',
  `qsg` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '千十个豹子',
  `wbg` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '万百个豹子',
  `wbs` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '万百十豹子',
  `wqb` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '前三豹子',
  `wqg` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '万千个豹子',
  `wqs` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '万千十豹子',
  `wsg` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '万十个豹子',
  `wxzs` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '五星组10',
  `wxzw` smallint(2) unsigned NOT NULL DEFAULT '0' COMMENT '五星组5',
  PRIMARY KEY (`bz_id`),
  UNIQUE KEY `u_bz_date` (`bz_date`) USING BTREE COMMENT '日期作为唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='豹子统计';

CREATE TABLE `buy_item` (
  `buy_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '关联人员',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `item_flag` tinyint(1) NOT NULL COMMENT '1-未开奖，2-已中奖，3-未中奖，4-已撤单',
  `buy_money` decimal(10,2) NOT NULL COMMENT '购买金钱',
  `ticket_id` int(11) NOT NULL COMMENT '票ID',
  PRIMARY KEY (`buy_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购买详细项';

CREATE TABLE `ssc_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `money` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '总金钱',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `now_no` varchar(3) NOT NULL DEFAULT '1' COMMENT '当前期数',
  `now_date` date NOT NULL COMMENT '当前日期',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `un_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='ssc用户';
INSERT INTO `ssc_user` VALUES (1, 'mzy', 100.00, '2018-09-15 16:39:38', '2018-10-23 13:45:33', '1', '2018-06-02');