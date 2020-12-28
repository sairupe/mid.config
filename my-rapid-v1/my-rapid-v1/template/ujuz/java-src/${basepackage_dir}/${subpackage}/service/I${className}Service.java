<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service;

import com.yyzf.core.models.Page;
import ${basepackage}.${subpackage}.dto.${className}Dto;

<#include "/java_imports.include">
public interface I${className}Service {

	/**
	 * ${table.tableAlias}修改
	 * @param ${classNameLower}
	 * @return 记录影响行数
	 * @throws Exception
	 */
	int update(${className}Dto ${classNameLower});

	/**
	 * ${table.tableAlias}添加
	 * @param ${classNameLower}
	 * @return 记录影响行数
	 * @throws Exception
	 */
	int insert(${className}Dto ${classNameLower});
}
