<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

<#include "/java_imports.include">
@Data
public class ${className}Entity implements Serializable {

    <#list table.columns as column>
	<#if column.sqlName != 'last_update_tm'>
    /** ${column.columnAlias} */
    private ${column.simpleJavaType} ${column.columnNameLower};
	</#if>

    </#list>
}
<#macro generateJavaColumns>
    <#list table.columns as column>
    <@generateBycondition column.sqlName>
    public void set${column.columnName}(${column.simpleJavaType} value) {
        this.${column.columnNameLower} = value;
    }
    
    public ${column.simpleJavaType} get${column.columnName}() {
        return this.${column.columnNameLower};
    }
    
    </@generateBycondition>
    </#list>
</#macro>
