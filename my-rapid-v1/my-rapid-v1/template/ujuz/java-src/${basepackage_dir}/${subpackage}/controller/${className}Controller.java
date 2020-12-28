<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.controller;

import com.yyzf.core.models.Page;
import com.yyzf.core.models.Result;
import ${basepackage}.${subpackage}.dto.${className}Dto;
import ${basepackage}.${subpackage}.service.I${className}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

<#include "/java_imports.include">
@Api("${table.tableAlias}")
@RestController
@Slf4j
@RequestMapping("/")
public class ${className}Controller {

    @Autowired
    private I${className}Service ${classNameLower}Service;


    @PutMapping
    @ApiOperation(value="更新${table.tableAlias}", tags={"更新${table.tableAlias}"})
    public Result<Integer> update(@Valid ${className}Dto ${classNameLower}Dto) {
        return Result.of("修改成功", ${classNameLower}Service.update(${classNameLower}Dto));
    }

    @PostMapping
    @ApiOperation(value="插入${table.tableAlias}", tags={"插入${table.tableAlias}"})
    public Result<Integer> insert(@Valid @RequestBody ${className}Dto ${classNameLower}Dto) {
        return Result.of("录入成功", ${classNameLower}Service.insert(${classNameLower}Dto));
    }

}
