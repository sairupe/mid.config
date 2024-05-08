/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.tiechat.web.api.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class FavorActivityDto implements Serializable {

	
	
    @ApiModelProperty(value = "主键id")
    private Long favorId;	
	
	@NotNull
    @ApiModelProperty(value = "用户id")
    private Long userId;	
	
	@NotNull
    @ApiModelProperty(value = "活动id")
    private Long activityId;	
	
	@NotNull
    @ApiModelProperty(value = "创建人id")
    private Long createdBy;	
	
	@NotNull
    @ApiModelProperty(value = "创建时间")
    private Long createdTm;	
	
	@NotNull
    @ApiModelProperty(value = "创建人姓名")
    private String createdName;	
	
	@NotNull
    @ApiModelProperty(value = "修改人id")
    private Long updatedBy;	
	
	@NotNull
    @ApiModelProperty(value = "修改时间")
    private Long updatedTm;	
	
	@NotNull
    @ApiModelProperty(value = "修改人姓名")
    private String updatedName;	
	
	@NotNull
    @ApiModelProperty(value = "删除时间")
    private Long deletedTm;	
	
	@NotNull
    @ApiModelProperty(value = "0-已删除，1-正常")
    private Integer isFlag;	
}
