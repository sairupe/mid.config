/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.gxbigdata.opd.service;

import com.gxbigdata.opd.dto.*;
import java.util.List;

/**
* TranscodeLog
 *
 * @author zh
 * @version v1.0
 * @CreationTime: - 2023-07-19 17:07:47
 * @Description:
 */
public interface ITranscodeLogService {

	/**
	 * TranscodeLog修改
	 */
	int update(TranscodeLogDto transcodeLog);

	/**
	 * TranscodeLog添加
	 */
	int insertBatch(List<TranscodeLogDto> insertList);
	
		/**
	 * TranscodeLog批量添加
	 */
	int insert(TranscodeLogDto transcodeLog);
	
	/**
	 * 根据ID获取课程分类
	 */
	TranscodeLogDto getById(Long categoryId);

	/**
	 * 批量根据ID获取课程分类
	 */
	List<TranscodeLogDto> getByIds(List<Long> idList);
	
	/**
	 * 根据ID删除
	 */
	int deleteById(DeleteByIdDto dto);

	/**
	 * 根据ID批量删除
	 */
	int deleteByIds(DeleteByIdsDto dto);
}
