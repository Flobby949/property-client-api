package com.soft2242.one.query;

import com.soft2242.one.common.query.Query;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
* 巡更记录表查询
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-05-25
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "巡更记录表查询")
public class PatrolRecordsQuery extends  Query{
    @Schema(description = "巡更人id")
    private Long inspectorId;
    @Schema(description = "今天日期")
    private String nowDate;

}