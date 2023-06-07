package com.soft2242.one.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 巡更记录表
 *
 * @author litao
 * @since 1.0.0 2023-05-25
 */
@Data
@Schema(description = "巡更记录表2")
public class TPatrolRecordsVO implements Serializable{
    private static final long serialVersionUID = 1L;

    @Schema(description = "自增主键")
    private Long id;

    @Schema(description = "巡更计划id")
    private Long planId;

    @Schema(description = "巡更路线id")
    private Long pathId;

    @Schema(description = "线路名称")
    private String wayName;

    @Schema(description = "小区名")
    private String communityName;

    @Schema(description = "楼宇名")
    private String buildingName;

    @Schema(description = "单元")
    private Integer units;

    @Schema(description = "开始时间")
    private String startTime;

    @Schema(description = "结束时间")
    private String endTime;

    @Schema(description = "巡更点id")
    private Long pointId;

    @Schema(description = "点名称")
    private String pointName;

    @Schema(description = "巡更人id")
    private Long inspectorId;

    @Schema(description = "巡更人姓名")
    private String REALNAME;

    @Schema(description = "电话号码")
    private String PHONE;

    @Schema(description = "巡检类型")
    private Integer type;

    @Schema(description = "巡更提交时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date inspectorTime;

    @Schema(description = "巡更结果")
    private String inspectorResult;

    @Schema(description = "拍照要求（0不要求拍照，1要求拍照）")
    private Integer photoRequirement;

    @Schema(description = "图片路径，用逗号隔开")
    private String photo;

    @Schema(description = "备注")
    private String notes;

    @Schema(description = "状态（0：未完成，1：已完成）")
    private Integer status;
    @Schema(description = "状态（0：正常，1：异常）")
    private Integer resultStatus;

}
