<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

import ${basepackage}.${subpackage}.entity.${className}Entity;

<#include "/java_imports.include">
@Mapper
public interface ${className}Mapper  {

	/**
	 * 获取${table.tableAlias}数据
	 * @param ${classNameLower}
	 * @return
	 */
	List<${className}Entity> getList(${className}Entity ${classNameLower});

	/**
	 * 获取${table.tableAlias}详情
	 * @param id
	 * @return
	 */
	${className}Entity get(String id);


	/**
	 * ${table.tableAlias}修改
	 * @param ${classNameLower}
	 * @return 记录影响行数
	 */
	int update(${className}Entity ${classNameLower});

	/**
	 * ${table.tableAlias}添加
	 * @param ${classNameLower}
	 * @return 记录影响行数
	 */
	int insert(${className}Entity ${classNameLower});

	/**
	 * ${table.tableAlias}删除
	 * @param ${classNameLower}
	 * @return 记录影响行数
	 */
	int delete(${className}Entity ${classNameLower});



}