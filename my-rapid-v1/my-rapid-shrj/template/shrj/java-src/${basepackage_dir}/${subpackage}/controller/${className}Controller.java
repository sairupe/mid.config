<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.controller;

import ${basepackage}.${subpackage}.service.I${className}Service;
import ${basepackage}.${subpackage}.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

<#include "/java_imports.include">
@Api("${table.tableAlias}")
@RestController
@Slf4j
@RequestMapping("/")
public class ${className}Controller {

    @Autowired
    private I${className}Service ${classNameLower}Service;


    @PostMapping("/update${className}")
    @ApiOperation(value="更新${table.tableAlias}", nickname="update${className}")
    public Result<Integer> update(@Valid @RequestBody ${className}Dto dto) {
        return Result.suc("修改成功", ${classNameLower}Service.update(dto));
    }

    @PostMapping("/insert${className}")
    @ApiOperation(value="插入${table.tableAlias}", nickname="insert${className}")
    public Result<Integer> insert(@Valid @RequestBody ${className}Dto dto) {
        return Result.suc("录入成功", ${classNameLower}Service.insert(dto));
    }
	
	@PostMapping("/insert${className}Batch")
    @ApiOperation(value="插入${table.tableAlias}", nickname="insert${className}Batch")
    public Result<Integer> insertBatch(@Valid @RequestBody List<${className}Dto> insertList) {
        return Result.suc("录入成功", ${classNameLower}Service.insertBatch(insertList));
    }

	@PostMapping("/getById")
    @ApiOperation(value="根据id获取${table.tableAlias}", nickname="get${className}ById")
    public Result<${className}Dto> getById(@Valid @RequestBody LongIdWrapperDto dto) {
		Long id = dto.getId();
        return Result.suc("查询成功", ${classNameLower}Service.getById(id));
    }
	
	@PostMapping("/getByIds")
    @ApiOperation(value="批量根据id获取${table.tableAlias}", nickname="get${className}ByIds")
    public Result<List<${className}Dto>> getByIds(@Valid @RequestBody LongIdsWrapperDto dto) {
		List<Long> idList = dto.getIdList();
        return Result.suc("查询成功", ${classNameLower}Service.getByIds(idList));
    }
	
	@PostMapping("/deleteById")
    @ApiOperation(value="根据id删除${table.tableAlias}", nickname="delete${className}ById")
    public Result<Integer> deleteById(@Valid @RequestBody DeleteByIdDto dto) {
        return Result.suc("删除成功", ${classNameLower}Service.deleteById(dto));
    }
	
	@PostMapping("/deleteByIds")
    @ApiOperation(value="批量根据id删除${table.tableAlias}", nickname="delete${className}ByIds")
    public Result<Integer> deletedByIds(@Valid @RequestBody DeleteByIdsDto dto) {
        return Result.suc("删除成功", ${classNameLower}Service.deleteByIds(dto));
    }

}
