/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.tiechat.web.api.service;

import com.tiechat.web.api.dto.*;
import java.util.List;

/**
* FavorActivity
 *
 * @author zh
 * @version v1.0
 * @CreationTime: - 2024-03-20 22:44:42
 * @Description:
 */
public interface IFavorActivityService {

	/**
	 * FavorActivity修改
	 */
	int update(FavorActivityDto favorActivity);

	/**
	 * FavorActivity添加
	 */
	int insertBatch(List<FavorActivityDto> insertList);
	
		/**
	 * FavorActivity批量添加
	 */
	int insert(FavorActivityDto favorActivity);
	
	/**
	 * 根据ID获取课程分类
	 */
	FavorActivityDto getById(Long categoryId);

	/**
	 * 批量根据ID获取课程分类
	 */
	List<FavorActivityDto> getByIds(List<Long> idList);
	
	/**
	 * 根据ID删除
	 */
	int deleteById(DeleteByIdDto dto);

	/**
	 * 根据ID批量删除
	 */
	int deleteByIds(DeleteByIdsDto dto);
}
