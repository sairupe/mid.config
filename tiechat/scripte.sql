CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(32) NOT NULL COMMENT '账号',
  `password` varchar(256) NOT NULL COMMENT '密码',
  `client_type` tinyint(4) NOT NULL COMMENT '客户端类型',
  `nick_name` varchar(32) NOT NULL COMMENT '昵称',
  `avatart` varchar(256) DEFAULT NULL COMMENT '头像地址',
  `created_by` bigint(20) NOT NULL COMMENT '创建人id',
  `created_tm` bigint(20) NOT NULL COMMENT '创建时间',
  `created_name` varchar(32) NOT NULL COMMENT '创建人姓名',
  `updated_by` bigint(20) NOT NULL COMMENT '修改人id',
  `updated_tm` bigint(20) NOT NULL COMMENT '修改时间',
  `updated_name` varchar(32) NOT NULL COMMENT '修改人姓名',
  `deleted_tm` bigint(20) NOT NULL COMMENT '删除时间',
  `is_flag` int(11) NOT NULL COMMENT '0-已删除，1-正常',
  `last_update_tm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '运维使用字段',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';

CREATE TABLE `sys_district` (
  `district_id` bigint(20) NOT NULL COMMENT '行政区id',
	`district_code` int(11) NOT NULL COMMENT '行政区代码',
  `district_name` varchar(32) NOT NULL COMMENT '行政区名称',
	`level` tinyint(4) NOT NULL COMMENT '层级',
  `parent_id` bigint(20) NOT NULL COMMENT '父亲节点',
  `route_path` varchar(256) NOT NULL COMMENT '路径路由信息',
  `created_by` bigint(20) NOT NULL COMMENT '创建人id',
  `created_tm` bigint(20) NOT NULL COMMENT '创建时间',
  `created_name` varchar(32) NOT NULL COMMENT '创建人姓名',
  `updated_by` bigint(20) NOT NULL COMMENT '修改人id',
  `updated_tm` bigint(20) NOT NULL COMMENT '修改时间',
  `updated_name` varchar(32) NOT NULL COMMENT '修改人姓名',
  `deleted_tm` bigint(20) NOT NULL COMMENT '删除时间',
  `is_flag` int(11) NOT NULL COMMENT '0-已删除，1-正常',
  `last_update_tm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '运维使用字段',
  PRIMARY KEY (`district_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='行政区域表';

CREATE TABLE `sys_poi` (
  `poi_id` bigint(20) NOT NULL COMMENT 'POI ID',
  `poi_name` varchar(128) NOT NULL COMMENT '行政区名称',
  `poi_address` varchar(128) NOT NULL COMMENT '行政区名称',
  `district_code` int(11) NOT NULL COMMENT '行政区代码',
  `longitude` double DEFAULT NULL COMMENT '经度',
  `latitude` double DEFAULT NULL COMMENT '维度',
  `uid` varchar(32) DEFAULT NULL COMMENT 'UID',
  `detail` JSON DEFAULT NULL COMMENT '其他详情',
  `created_by` bigint(20) NOT NULL COMMENT '创建人id',
  `created_tm` bigint(20) NOT NULL COMMENT '创建时间',
  `created_name` varchar(32) NOT NULL COMMENT '创建人姓名',
  `updated_by` bigint(20) NOT NULL COMMENT '修改人id',
  `updated_tm` bigint(20) NOT NULL COMMENT '修改时间',
  `updated_name` varchar(32) NOT NULL COMMENT '修改人姓名',
  `deleted_tm` bigint(20) NOT NULL COMMENT '删除时间',
  `is_flag` int(11) NOT NULL COMMENT '0-已删除，1-正常',
  `last_update_tm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '运维使用字段',
  PRIMARY KEY (`poi_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='地图POI信息表';