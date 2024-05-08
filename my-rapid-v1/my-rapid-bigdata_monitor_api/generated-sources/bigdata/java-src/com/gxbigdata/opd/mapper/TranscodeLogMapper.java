/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.gxbigdata.opd.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.gxbigdata.opd.dto.*;
import com.gxbigdata.opd.entity.TranscodeLogEntity;

/**
* TranscodeLog
 *
 * @author zh
 * @version v1.0
 * @CreationTime: - 2023-07-19 17:07:47
 * @Description:
 */
@Mapper
public interface TranscodeLogMapper  {

	/**
	 * TranscodeLog修改
	 */
	int update(TranscodeLogEntity transcodeLog);

	/**
	 * TranscodeLog添加
	 */
	int insert(TranscodeLogEntity transcodeLog);
	
	/**
	 * TranscodeLog批量添加
	 */
	int insertBatch(List<TranscodeLogEntity> insertList);
	
    /**
     * 根据ID获取
     */
    TranscodeLogEntity getById(@Param("id") Long id);

    /**
     * 根据ID列表获取
     */
    List<TranscodeLogEntity> getByIds(@Param("ids") List<Long> ids);
	
	/**
     * 根据ID批量删除
     */
    int deleteByIds(@Param("ids") List<Long> ids,
                    @Param("updatedBy") Long updatedBy,
                    @Param("updatedName") String updatedName,
                    @Param("updatedTm") Long updatedTm);
					
	/**
     * 根据ID删除
     */
    int deleteById(@Param("id") Long id,
                    @Param("updatedBy") Long updatedBy,
                    @Param("updatedName") String updatedName,
                    @Param("updatedTm") Long updatedTm);
}