<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.service;

import com.yjyz.core.models.Page;
import ${basepackage}.${subpackage}.dto.${className}Dto;

<#include "/java_imports.include">
public interface I${className}Service {

	/**
	 * 获取${table.tableAlias}分页数据
	 * @param page
	 * @return
	 * @throws Exception
	 * */
	Page<${className}Dto> get${className}List(int pageNo, int pageSize, ${className}Dto ${classNameLower});

	/**
	 * 获取${table.tableAlias}对象
	 * @param id
	 * @return
	 */
	${className}Dto get(String id);

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

	/**
	 * ${table.tableAlias}删除
	 * @param ${classNameLower}
	 * @return 记录影响行数
	 * @throws Exception
	 */
	int delete(${className}Dto ${classNameLower});
}
