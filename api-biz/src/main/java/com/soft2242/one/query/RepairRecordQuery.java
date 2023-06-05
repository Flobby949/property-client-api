package com.soft2242.one.query;

import com.soft2242.one.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 报修处理表查询
*
* @author litao
* @since 1.0.0 2023-06-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "报修处理表查询")
public class RepairRecordQuery extends Query {
    @Schema(description = "处理人id，逗号分隔")
    private String employeeIds;
    @Schema(description = "状态")
    private Integer status;
}