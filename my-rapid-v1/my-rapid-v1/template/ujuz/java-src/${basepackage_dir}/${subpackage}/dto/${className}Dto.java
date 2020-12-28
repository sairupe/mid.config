<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${subpackage}.dto;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

<#include "/java_imports.include">
@Data
public class ${className}Dto implements Serializable {

    <#list table.columns as column>
    /** ${column.columnAlias} */
    ${column.hibernateValidatorExprssion}
    @ApiModelProperty(value = "${column.columnAlias}", notes = "${column.hibernateValidatorExprssion}")
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
