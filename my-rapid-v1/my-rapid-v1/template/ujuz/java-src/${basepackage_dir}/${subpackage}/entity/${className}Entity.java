<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.entity;

import lombok.Data;

import java.io.Serializable;

<#include "/java_imports.include">
@Data
public class ${className}Entity implements Serializable {

    <#list table.columns as column>
    //${column.hibernateValidatorExprssion}
    /** ${column.columnAlias} */
    private ${column.simpleJavaType} ${column.columnNameLower};

    </#list>
    // start-处理日期参数查询条件
    <#list table.columns as column>
    <#if column.isDateTimeColumn>

    /** ${column.columnAlias}字符串类型 */
    private String ${column.columnNameLower}Str;

    /** ${column.columnAlias}开始时间 */
    private String ${column.columnNameLower}Begin;

    /** ${column.columnAlias}结束时间 */
    private String ${column.columnNameLower}End;

    </#if>
    </#list>
    // end-处理日期参数查询条件
        

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
