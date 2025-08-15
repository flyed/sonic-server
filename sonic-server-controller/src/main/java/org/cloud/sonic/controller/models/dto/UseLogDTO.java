package org.cloud.sonic.controller.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.cloud.sonic.controller.models.base.TypeConverter;
import org.cloud.sonic.controller.models.domain.UseLog;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuzhiyuan
 * @version 1.0
 * @since 2025/7/22 21:15
 */
@Schema(name = "使用记录DTO 模型")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UseLogDTO implements Serializable, TypeConverter<UseLogDTO, UseLog> {

    @Schema(description = "记录 ID", example = "1")
    private Integer id;

    @Schema(description = "设备ID", example = "1")
    @NotNull(message = "设备ID不能为空")
    Integer deviceId;

    @NotNull(message = "开始时间不能为空")
    @Schema(description = "开始时间", required = true, example = "")
    Date startTime;

    @NotNull(message = "结束时间不能为空")
    @Schema(description = "结束时间", required = true, example = "")
    Date endTime;
}
