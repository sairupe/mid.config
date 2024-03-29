<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import ${basepackage}.${subpackage}.mapper.${className}Mapper;
import ${basepackage}.${subpackage}.dto.*;
import ${basepackage}.${subpackage}.entity.${className}Entity;
import ${basepackage}.${subpackage}.service.I${className}Service;
import ${basepackage}.${subpackage}.utils.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


<#include "/java_imports.include">
@Service
public class ${className}ServiceImpl implements I${className}Service {

    @Resource
    private ${className}Mapper ${classNameLower}Mapper;

    @Override
    public int update(${className}Dto dto){
        return ${classNameLower}Mapper.update(
                BeansUtilz.copyProperties(dto, ${className}Entity.class));
    }

    @Override
    public int insert(${className}Dto dto){
        return ${classNameLower}Mapper.insert(
        BeansUtilz.copyProperties(dto, ${className}Entity.class));
    }
	
	
	@Override
    public int insertBatch(List<${className}Dto> insertList){
        return ${classNameLower}Mapper.insertBatch(BeansUtilz.copyProperties(insertList, ${className}Entity.class));
    }
	
	@Override
    public ${className}Dto getById(Long ${classNameLower}Id){
        ${className}Entity entity = ${classNameLower}Mapper.getById(${classNameLower}Id);
		${className}Dto result = BeansUtilz.copyProperties(entity, ${className}Dto.class);
		return result;
    }

    @Override
    public List<${className}Dto> getByIds(List<Long> idList){
		List<${className}Entity> entityList = ${classNameLower}Mapper.getByIds(idList);
		List<${className}Dto> result = BeansUtilz.copyProperties(entityList, ${className}Dto.class);
        return result;
    }
	
	@Override
    public int deleteById(DeleteByIdDto dto){
		Long id = dto.getId();
        Long updatedBy = dto.getUpdatedBy();
        String updatedName = dto.getUpdatedName();
        Long updatedTm = dto.getUpdatedTm();
        int result = ${classNameLower}Mapper.deleteById(id, updatedBy, updatedName, updatedTm);
        return result;
    }

    @Override
    public int deleteByIds(DeleteByIdsDto dto){
        List<Long> ids = dto.getIds();
        Long updatedBy = dto.getUpdatedBy();
        String updatedName = dto.getUpdatedName();
        Long updatedTm = dto.getUpdatedTm();
        int result = ${classNameLower}Mapper.deleteByIds(ids, updatedBy, updatedName, updatedTm);
		return result;
    }
}
