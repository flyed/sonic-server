package org.cloud.sonic.controller.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.cloud.sonic.common.config.WebAspect;
import org.cloud.sonic.common.http.RespEnum;
import org.cloud.sonic.common.http.RespModel;
import org.cloud.sonic.controller.models.domain.Devices;
import org.cloud.sonic.controller.models.domain.UseLog;
import org.cloud.sonic.controller.models.domain.Users;
import org.cloud.sonic.controller.models.dto.UseLogDTO;
import org.cloud.sonic.controller.services.DevicesService;
import org.cloud.sonic.controller.services.UseLogService;
import org.cloud.sonic.controller.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author liuzhiyuan
 * @version 1.0
 * @since 2025/7/22 21:21
 */
@Tag(name = "useLog相关")
@RestController
@RequestMapping("/use-log")
public class UseLogController {

    @Autowired
    private UseLogService useLogService;
    @Autowired
    private UsersService usersService;
    private DevicesService devicesService;

    @WebAspect
    @Operation(summary = "记录使用日志", description = "记录使用日志")
    @PostMapping
    public RespModel<String> save(@Validated @RequestBody UseLogDTO useLogDTO, HttpServletRequest request) {
        String token = request.getHeader("SonicToken");
        if (token == null) {
            return new RespModel(RespEnum.UNAUTHORIZED);
        }
        UseLog useLog = useLogDTO.convertTo();
        Users users = usersService.getUserInfo(token);
        Devices devices = devicesService.getById(useLogDTO.getDeviceId());
        useLog.setUsername(users.getUserName());
        useLog.setUdId(devices.getUdId());
        useLog.setUserId(users.getId());
        useLogService.save(useLog);
        return new RespModel<>(RespEnum.UPDATE_OK);
    }

}
