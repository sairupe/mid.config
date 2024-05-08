/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.tiechat.web.api.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* FavorActivity
 *
 * @author zh
 * @version v1.0
 * @CreationTime: - 2024-03-20 22:44:42
 * @Description:
 */
@Data
public class FavorActivityEntity implements Serializable {

    /** 主键id */
    private Long favorId;

    /** 用户id */
    private Long userId;

    /** 活动id */
    private Long activityId;

    /** 创建人id */
    private Long createdBy;

    /** 创建时间 */
    private Long createdTm;

    /** 创建人姓名 */
    private String createdName;

    /** 修改人id */
    private Long updatedBy;

    /** 修改时间 */
    private Long updatedTm;

    /** 修改人姓名 */
    private String updatedName;

    /** 删除时间 */
    private Long deletedTm;

    /** 0-已删除，1-正常 */
    private Integer isFlag;


}
