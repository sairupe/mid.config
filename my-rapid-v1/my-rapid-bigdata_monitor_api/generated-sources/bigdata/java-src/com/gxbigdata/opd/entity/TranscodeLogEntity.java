/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.gxbigdata.opd.entity;

import lombok.Data;

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
public class TranscodeLogEntity implements Serializable {

    /** 日志Id */
    private Long logId;

    /** 调用方IP */
    private String callIp;

    /** http版本 */
    private String httpVersion;

    /** 请求头 */
    private String headers;

    /** 原生请求头 */
    private String rawHeader;

    /** 请求路径 */
    private String uri;

    /** 请求路径 */
    private String requestUri;

    /** URL参数 */
    private String uriArgs;

    /** 请求方法 */
    private String method;

    /** body参数 */
    private String bodyData;

    /** 响应参数 */
    private String responseData;

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

    /** 0-已删除，1-正常 */
    private Integer isFlag;


}
