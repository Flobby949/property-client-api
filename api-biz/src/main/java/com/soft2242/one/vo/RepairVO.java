package com.soft2242.one.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import com.soft2242.one.common.utils.DateUtils;
import java.io.Serializable;
import java.util.Date;

/**
* 报修表
*
* @author litao
* @since 1.0.0 2023-06-05
*/
@Data
@Schema(description = "报修表")
public class RepairVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "社区id")
	private Long communityId;

	@Schema(description = "报修人id")
	private Long userId;

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

	@Schema(description = "处理状态（0：未处理，1：处理中，2：已处理，3：已评价）")
	private Integer state;

	@Schema(description = "处理人id，逗号分隔")
	private String employeeIds;

	@Schema(description = "处理结果")
	private String result;

	@Schema(description = "处理时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date handleTime;

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