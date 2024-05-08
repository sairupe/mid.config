/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.tiechat.web.api.controller;

import com.tiechat.web.api.service.IFavorActivityService;
import com.tiechat.web.api.dto.*;
import com.tiechat.web.api.common.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* FavorActivity
 *
 * @author zh
 * @version v1.0
 * @CreationTime: - 2024-03-20 22:44:42
 * @Description:
 */
@Api("FavorActivity")
@RestController
@Slf4j
@RequestMapping("/")
public class FavorActivityController {

    @Autowired
    private IFavorActivityService favorActivityService;


    @PostMapping("/updateFavorActivity")
    @ApiOperation(value="更新FavorActivity", nickname="updateFavorActivity")
    public Result<Integer> update(@RequestBody FavorActivityDto dto) {
        return Result.suc("修改成功", favorActivityService.update(dto));
    }

    @PostMapping("/insertFavorActivity")
    @ApiOperation(value="插入FavorActivity", nickname="insertFavorActivity")
    public Result<Integer> insert(@Valid @RequestBody FavorActivityDto dto) {
        return Result.suc("录入成功", favorActivityService.insert(dto));
    }
	
	@PostMapping("/insertFavorActivityBatch")
    @ApiOperation(value="插入FavorActivity", nickname="insertFavorActivityBatch")
    public Result<Integer> insertBatch(@Valid @RequestBody List<FavorActivityDto> insertList) {
        return Result.suc("录入成功", favorActivityService.insertBatch(insertList));
    }

	@PostMapping("/getById")
    @ApiOperation(value="根据id获取FavorActivity", nickname="getFavorActivityById")
    public Result<FavorActivityDto> getById(@Valid @RequestBody LongIdWrapperDto dto) {
		Long id = dto.getId();
        return Result.suc("查询成功", favorActivityService.getById(id));
    }
	
	@PostMapping("/getByIds")
    @ApiOperation(value="批量根据id获取FavorActivity", nickname="getFavorActivityByIds")
    public Result<List<FavorActivityDto>> getByIds(@Valid @RequestBody LongIdsWrapperDto dto) {
		List<Long> idList = dto.getIdList();
        return Result.suc("查询成功", favorActivityService.getByIds(idList));
    }
	
	@PostMapping("/deleteById")
    @ApiOperation(value="根据id删除FavorActivity", nickname="deleteFavorActivityById")
    public Result<Integer> deleteById(@Valid @RequestBody DeleteByIdDto dto) {
        return Result.suc("删除成功", favorActivityService.deleteById(dto));
    }
	
	@PostMapping("/deleteByIds")
    @ApiOperation(value="批量根据id删除FavorActivity", nickname="deleteFavorActivityByIds")
    public Result<Integer> deletedByIds(@Valid @RequestBody DeleteByIdsDto dto) {
        return Result.suc("删除成功", favorActivityService.deleteByIds(dto));
    }

}
