package org.cloud.sonic.controller.services.impl;

import org.cloud.sonic.controller.mapper.UseLogMapper;
import org.cloud.sonic.controller.models.domain.UseLog;
import org.cloud.sonic.controller.services.UseLogService;
import org.cloud.sonic.controller.services.impl.base.SonicServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author liuzhiyuan
 * @version 1.0
 * @since 2025/7/22 21:24
 */

@Service
public class UseLogServiceImpl extends SonicServiceImpl<UseLogMapper, UseLog> implements UseLogService {
}
