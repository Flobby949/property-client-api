package com.soft2242.one.query;
import com.soft2242.one.common.query.Query;
import com.soft2242.one.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "巡更记录表查询2")
public class TPatrolRecordsQuey extends Query {

    @Schema(description = "日期查找")
    private String patrolDate;

    @Schema(description = "巡更人id")
    private Long inspectorId;
}
