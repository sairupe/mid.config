/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.gxbigdata.opd.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

/**
* TranscodeLog
 *
 * @author zh
 * @version v1.0
 * @CreationTime: - 2023-07-19 17:07:47
 * @Description:
 */
@Data
public class TranscodeLogDto implements Serializable {

	
	
    @ApiModelProperty(value = "日志Id")
    private Long logId;	
	
	
    @ApiModelProperty(value = "调用方IP")
    private String callIp;	
	
	
    @ApiModelProperty(value = "http版本")
    private String httpVersion;	
	
	
    @ApiModelProperty(value = "请求头")
    private String headers;	
	
	
    @ApiModelProperty(value = "原生请求头")
    private String rawHeader;	
	
	
    @ApiModelProperty(value = "请求路径")
    private String uri;	
	
	
    @ApiModelProperty(value = "请求路径")
    private String requestUri;	
	
	
    @ApiModelProperty(value = "URL参数")
    private String uriArgs;	
	
	
    @ApiModelProperty(value = "请求方法")
    private String method;	
	
	
    @ApiModelProperty(value = "body参数")
    private String bodyData;	
	
	
    @ApiModelProperty(value = "响应参数")
    private String responseData;	
	
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
    @ApiModelProperty(value = "0-已删除，1-正常")
    private Integer isFlag;	
}
