/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.gxbigdata.opd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gxbigdata.opd.mapper.TranscodeLogMapper;
import com.gxbigdata.opd.dto.*;
import com.gxbigdata.opd.entity.TranscodeLogEntity;
import com.gxbigdata.opd.service.ITranscodeLogService;
import com.gxbigdata.opd.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
* TranscodeLog
 *
 * @author zh
 * @version v1.0
 * @CreationTime: - 2023-07-19 17:07:47
 * @Description:
 */
@Service
public class TranscodeLogServiceImpl implements ITranscodeLogService {

    @Resource
    private TranscodeLogMapper transcodeLogMapper;

    @Override
    public int update(TranscodeLogDto dto){
        return transcodeLogMapper.update(
                BeansUtilz.copyProperties(dto, TranscodeLogEntity.class));
    }

    @Override
    public int insert(TranscodeLogDto dto){
        return transcodeLogMapper.insert(
        BeansUtilz.copyProperties(dto, TranscodeLogEntity.class));
    }
	
	
	@Override
    public int insertBatch(List<TranscodeLogDto> insertList){
        return transcodeLogMapper.insertBatch(BeansUtilz.copyProperties(insertList, TranscodeLogEntity.class));
    }
	
	@Override
    public TranscodeLogDto getById(Long transcodeLogId){
        TranscodeLogEntity entity = transcodeLogMapper.getById(transcodeLogId);
		TranscodeLogDto result = BeansUtilz.copyProperties(entity, TranscodeLogDto.class);
		return result;
    }

    @Override
    public List<TranscodeLogDto> getByIds(List<Long> idList){
		List<TranscodeLogEntity> entityList = transcodeLogMapper.getByIds(idList);
		List<TranscodeLogDto> result = BeansUtilz.copyProperties(entityList, TranscodeLogDto.class);
        return result;
    }
	
	@Override
    public int deleteById(DeleteByIdDto dto){
		Long id = dto.getId();
        Long updatedBy = dto.getUpdatedBy();
        String updatedName = dto.getUpdatedName();
        Long updatedTm = dto.getUpdatedTm();
        int result = transcodeLogMapper.deleteById(id, updatedBy, updatedName, updatedTm);
        return result;
    }

    @Override
    public int deleteByIds(DeleteByIdsDto dto){
        List<Long> ids = dto.getIds();
        Long updatedBy = dto.getUpdatedBy();
        String updatedName = dto.getUpdatedName();
        Long updatedTm = dto.getUpdatedTm();
        int result = transcodeLogMapper.deleteByIds(ids, updatedBy, updatedName, updatedTm);
		return result;
    }
}
