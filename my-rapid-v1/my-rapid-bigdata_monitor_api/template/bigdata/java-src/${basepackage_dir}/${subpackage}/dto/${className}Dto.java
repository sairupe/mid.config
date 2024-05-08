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
import java.util.Date;

<#include "/java_imports.include">
@Data
public class ${className}Dto implements Serializable {

    <#list table.columns as column>
	<#if column.sqlName != 'last_update_tm'>
	
	${column.hibernateValidatorExprssion}
    @ApiModelProperty(value = "${column.columnAlias}")
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
