<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service.impl;

import com.yyzf.core.models.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ${basepackage}.${subpackage}.dao.${className}Mapper;
import ${basepackage}.${subpackage}.dto.${className}Dto;
import ${basepackage}.${subpackage}.entity.${className}Entity;
import ${basepackage}.${subpackage}.service.I${className}Service;
import ${basepackage}.${subpackage}.utils.BeansUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


<#include "/java_imports.include">
@Service
public class ${className}ServiceImpl implements I${className}Service {

    @Resource
    private ${className}Mapper ${classNameLower}Mapper;

    @Override
    public int update(${className}Dto ${classNameLower}){
        return ${classNameLower}Mapper.update(
                BeansUtils.copyProperties(${classNameLower}, ${className}Entity.class));
    }

    @Override
    public int insert(${className}Dto ${classNameLower}){
        return ${classNameLower}Mapper.insert(
                 BeansUtils.copyProperties(${classNameLower}, ${className}Entity.class));
    }
}
