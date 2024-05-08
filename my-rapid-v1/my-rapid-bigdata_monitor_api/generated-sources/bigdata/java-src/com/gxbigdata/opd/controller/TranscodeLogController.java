/*
 * Copyright(c) 2022 TieChat All rights reserved.
 */
package com.gxbigdata.opd.controller;

import com.gxbigdata.opd.service.ITranscodeLogService;
import com.gxbigdata.opd.dto.*;
import com.gxbigdata.opd.common.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
* TranscodeLog
 *
 * @author zh
 * @version v1.0
 * @CreationTime: - 2023-07-19 17:07:47
 * @Description:
 */
@Api("TranscodeLog")
@RestController
@Slf4j
@RequestMapping("/")
public class TranscodeLogController {

    @Autowired
    private ITranscodeLogService transcodeLogService;


    @PostMapping("/updateTranscodeLog")
    @ApiOperation(value="更新TranscodeLog", nickname="updateTranscodeLog")
    public Result<Integer> update(@RequestBody TranscodeLogDto dto) {
        return Result.suc("修改成功", transcodeLogService.update(dto));
    }

    @PostMapping("/insertTranscodeLog")
    @ApiOperation(value="插入TranscodeLog", nickname="insertTranscodeLog")
    public Result<Integer> insert(@Valid @RequestBody TranscodeLogDto dto) {
        return Result.suc("录入成功", transcodeLogService.insert(dto));
    }
	
	@PostMapping("/insertTranscodeLogBatch")
    @ApiOperation(value="插入TranscodeLog", nickname="insertTranscodeLogBatch")
    public Result<Integer> insertBatch(@Valid @RequestBody List<TranscodeLogDto> insertList) {
        return Result.suc("录入成功", transcodeLogService.insertBatch(insertList));
    }

	@PostMapping("/getById")
    @ApiOperation(value="根据id获取TranscodeLog", nickname="getTranscodeLogById")
    public Result<TranscodeLogDto> getById(@Valid @RequestBody LongIdWrapperDto dto) {
		Long id = dto.getId();
        return Result.suc("查询成功", transcodeLogService.getById(id));
    }
	
	@PostMapping("/getByIds")
    @ApiOperation(value="批量根据id获取TranscodeLog", nickname="getTranscodeLogByIds")
    public Result<List<TranscodeLogDto>> getByIds(@Valid @RequestBody LongIdsWrapperDto dto) {
		List<Long> idList = dto.getIdList();
        return Result.suc("查询成功", transcodeLogService.getByIds(idList));
    }
	
	@PostMapping("/deleteById")
    @ApiOperation(value="根据id删除TranscodeLog", nickname="deleteTranscodeLogById")
    public Result<Integer> deleteById(@Valid @RequestBody DeleteByIdDto dto) {
        return Result.suc("删除成功", transcodeLogService.deleteById(dto));
    }
	
	@PostMapping("/deleteByIds")
    @ApiOperation(value="批量根据id删除TranscodeLog", nickname="deleteTranscodeLogByIds")
    public Result<Integer> deletedByIds(@Valid @RequestBody DeleteByIdsDto dto) {
        return Result.suc("删除成功", transcodeLogService.deleteByIds(dto));
    }

}
