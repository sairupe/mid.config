<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${subpackage}.dao;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import ${basepackage}.${subpackage}.dto.*;
import ${basepackage}.${subpackage}.entity.${className}Entity;

<#include "/java_imports.include">
@Mapper
public interface ${className}Mapper  {

	/**
	 * ${table.tableAlias}修改
	 */
	int update(${className}Entity ${classNameLower});

	/**
	 * ${table.tableAlias}添加
	 */
	int insert(${className}Entity ${classNameLower});
	
	/**
	 * ${table.tableAlias}批量添加
	 */
	int insertBatch(List<${className}Entity> insertList);
	
    /**
     * 根据ID获取
     */
    ${className}Entity getById(@Param("id") Long id);

    /**
     * 根据ID列表获取
     */
    List<${className}Entity> getByIds(@Param("ids") List<Long> ids);
	
	/**
     * 根据ID批量删除
     */
    int deleteByIds(@Param("ids") List<Long> ids,
                    @Param("updatedBy") Long updatedBy,
                    @Param("updatedName") String updatedName,
                    @Param("updatedTm") Long updatedTm);
					
	/**
     * 根据ID删除
     */
    int deleteById(@Param("id") Long id,
                    @Param("updatedBy") Long updatedBy,
                    @Param("updatedName") String updatedName,
                    @Param("updatedTm") Long updatedTm);
}