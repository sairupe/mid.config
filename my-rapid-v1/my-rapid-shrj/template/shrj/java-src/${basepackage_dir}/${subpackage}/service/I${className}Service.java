<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service;

import ${basepackage}.${subpackage}.dto.*;
import java.util.List;

<#include "/java_imports.include">
public interface I${className}Service {

	/**
	 * ${table.tableAlias}修改
	 */
	int update(${className}Dto ${classNameLower});

	/**
	 * ${table.tableAlias}添加
	 */
	int insertBatch(List<${className}Dto> insertList);
	
		/**
	 * ${table.tableAlias}批量添加
	 */
	int insert(${className}Dto ${classNameLower});
	
	/**
	 * 根据ID获取课程分类
	 */
	${className}Dto getById(Long categoryId);

	/**
	 * 批量根据ID获取课程分类
	 */
	List<${className}Dto> getByIds(List<Long> idList);
	
	/**
	 * 根据ID删除
	 */
	int deleteById(DeleteByIdDto dto);

	/**
	 * 根据ID批量删除
	 */
	int deleteByIds(DeleteByIdsDto dto);
}
