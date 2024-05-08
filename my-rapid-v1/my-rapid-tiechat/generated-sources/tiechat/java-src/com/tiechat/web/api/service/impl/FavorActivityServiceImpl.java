/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.tiechat.web.api.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.tiechat.web.api.mapper.FavorActivityMapper;
import com.tiechat.web.api.dto.*;
import com.tiechat.web.api.entity.FavorActivityEntity;
import com.tiechat.web.api.service.IFavorActivityService;
import com.tiechat.web.api.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
* FavorActivity
 *
 * @author zh
 * @version v1.0
 * @CreationTime: - 2024-03-20 22:44:42
 * @Description:
 */
@Service
public class FavorActivityServiceImpl implements IFavorActivityService {

    @Resource
    private FavorActivityMapper favorActivityMapper;

    @Override
    public int update(FavorActivityDto dto){
        return favorActivityMapper.update(
                BeansUtilz.copyProperties(dto, FavorActivityEntity.class));
    }

    @Override
    public int insert(FavorActivityDto dto){
        return favorActivityMapper.insert(
        BeansUtilz.copyProperties(dto, FavorActivityEntity.class));
    }
	
	
	@Override
    public int insertBatch(List<FavorActivityDto> insertList){
        return favorActivityMapper.insertBatch(BeansUtilz.copyProperties(insertList, FavorActivityEntity.class));
    }
	
	@Override
    public FavorActivityDto getById(Long favorActivityId){
        FavorActivityEntity entity = favorActivityMapper.getById(favorActivityId);
		FavorActivityDto result = BeansUtilz.copyProperties(entity, FavorActivityDto.class);
		return result;
    }

    @Override
    public List<FavorActivityDto> getByIds(List<Long> idList){
		List<FavorActivityEntity> entityList = favorActivityMapper.getByIds(idList);
		List<FavorActivityDto> result = BeansUtilz.copyProperties(entityList, FavorActivityDto.class);
        return result;
    }
	
	@Override
    public int deleteById(DeleteByIdDto dto){
		Long id = dto.getId();
        Long updatedBy = dto.getUpdatedBy();
        String updatedName = dto.getUpdatedName();
        Long updatedTm = dto.getUpdatedTm();
        int result = favorActivityMapper.deleteById(id, updatedBy, updatedName, updatedTm);
        return result;
    }

    @Override
    public int deleteByIds(DeleteByIdsDto dto){
        List<Long> ids = dto.getIds();
        Long updatedBy = dto.getUpdatedBy();
        String updatedName = dto.getUpdatedName();
        Long updatedTm = dto.getUpdatedTm();
        int result = favorActivityMapper.deleteByIds(ids, updatedBy, updatedName, updatedTm);
		return result;
    }
}
