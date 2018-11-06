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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='票';

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