/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.tiechat.web.api.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.tiechat.web.api.dto.*;
import com.tiechat.web.api.entity.FavorActivityEntity;

/**
* FavorActivity
 *
 * @author zh
 * @version v1.0
 * @CreationTime: - 2024-03-20 22:44:42
 * @Description:
 */
@Mapper
public interface FavorActivityMapper  {

	/**
	 * FavorActivity修改
	 */
	int update(FavorActivityEntity favorActivity);

	/**
	 * FavorActivity添加
	 */
	int insert(FavorActivityEntity favorActivity);
	
	/**
	 * FavorActivity批量添加
	 */
	int insertBatch(List<FavorActivityEntity> insertList);
	
    /**
     * 根据ID获取
     */
    FavorActivityEntity getById(@Param("id") Long id);

    /**
     * 根据ID列表获取
     */
    List<FavorActivityEntity> getByIds(@Param("ids") List<Long> ids);
	
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