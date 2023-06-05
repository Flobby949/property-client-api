package com.soft2242.one.query;

import com.soft2242.one.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* 报修表查询
*
* @author litao
* @since 1.0.0 2023-06-05
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "报修表查询")
public class RepairQuery extends Query {
    @Schema(description = "报修类别(0:公共报修，1：个人报修)")
    private Integer type;

    @Schema(description = "处理状态（0：未处理，1：处理中，2：已处理，3：已评价）")
    private Integer state;

}