package com.soft2242.one.vo;

import com.soft2242.one.common.utils.DateUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
* 报修处理表
*
* @author 软件2242 soft2242@gmail.com
* @since 1.0.0 2023-06-05
*/
@Data
@Schema(description = "报修处理表")
public class RepairRecordVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Schema(description = "自增主键")
	private Long id;

	@Schema(description = "报修信息id")
	private Long repairId;

	@Schema(description = "位置")
	private String place;

	@Schema(description = "标题")
	private String title;

	@Schema(description = "内容")
	private String content;

	@Schema(description = "类型")
	private Integer type;

	@Schema(description = "保修时间")
	@JsonFormat(pattern = DateUtils.DATE_TIME_PATTERN)
	private Date createTimeRepair;


	@Schema(description = "处理人id，逗号分隔")
	private String employeeIds;

	@Schema(description = "处理状态（0：未处理，1：处理中，2：已完成）")
	private Integer state;

	@Schema(description = "处理结果")
	private String result;

	@Schema(description = "现场照片")
	private String imgs;
}