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