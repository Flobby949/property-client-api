package com.soft2242.one.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soft2242.one.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 报修详情
 *
 * @author 软件2242 soft2242@gmail.com
 * @since 1.0.0 2023-06-05
 */
@Data
@Schema(description = "报修详情")
public class OrderDetailVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "自增主键")
    private Long id;

    @Schema(description = "社区id")
    private Long communityId;

    @Schema(description = "报修人id")
    private Long userId;

    @Schema(description = "报修人姓名")
    private String username;

    @Schema(description = "手机号")
    private String phone ;


    @Schema(description = "判断这个报修人的身份（0是用户，1是物业)")
    private Integer userType;

    @Schema(description = "报修类别(0:公共报修，1：个人报修)")
    private Integer type;

    @Schema(description = "报修类型(0:路灯，1：厕所)")
    private Integer category;

    @Schema(description = "报修地址")
    private String place;

    @Schema(description = "报修标题")
    private String title;

    @Schema(description = "报修内容")
    private String content;

    @Schema(description = "图片")
    private String imgs;

    @Schema(description = "结果图片")
    private String resultImgs;

    @Schema(description = "处理状态（0：未处理，1：处理中，2：已处理，3：已评价）")
    private Integer state;

    @Schema(description = "处理人id，逗号分隔")
    private String employeeIds;

    @Schema(description = "处理结果人")
    private String resultName;

    @Schema(description = "处理人")
    private String handlerName;

    @Schema(description = "处理结果")
    private String result;

    @Schema(description = "处理时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date handleTime;

    @Schema(description = "分配时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date allocateTime;

    @Schema(description = "报修评价")
    private String evaluate;

    @Schema(description = "报修评价时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date evaluateTime;

    @Schema(description = "删除标识（0：未删除 1：已删除）")
    private Integer deleted;

    @Schema(description = "创建时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date createTime;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
    private Date updateTime;

    @Schema(description = "创建者")
    private Long creator;

    @Schema(description = "更新者")
    private Long updater;
}
