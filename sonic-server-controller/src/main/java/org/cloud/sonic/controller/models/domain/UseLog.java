package org.cloud.sonic.controller.models.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlEngineConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author liuzhiyuan
 * @version 1.0
 * @since 2025/7/22 21:17
 */
@Schema(name ="UseLog对象", description = "")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("use_log")
@TableComment("UseLog记录表")
@TableCharset(MySqlCharsetConstant.DEFAULT)
@TableEngine(MySqlEngineConstant.InnoDB)
public class UseLog {
    @TableId(value = "id", type = IdType.AUTO)
    @IsAutoIncrement
    private Integer id;

    @TableField
    @Column(value = "device_id", isNull = false, comment = "设备编号")
    private Integer deviceId;

    @TableField
    @Column(value = "start_time", isNull = false, comment = "开始时间",type = MySqlTypeConstant.DATETIME)
    private Date startTime;

    @TableField
    @Column(value = "end_time", isNull = false, comment = "结束时间",type = MySqlTypeConstant.DATETIME)
    private Date endTime;

    @TableField
    @Column(value = "user_id", isNull = false, comment = "操作人")
    private Integer userId;

    @Schema(description = "创建时间", example = "2021-08-15 11:36:00")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    @Column(value = "create_time", type = MySqlTypeConstant.DATETIME, isNull = false, comment = "创建时间")
    private Date createTime;

}
