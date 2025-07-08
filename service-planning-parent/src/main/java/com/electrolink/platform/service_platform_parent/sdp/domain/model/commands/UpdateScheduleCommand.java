package com.electrolink.platform.service_platform_parent.sdp.domain.model.commands;

import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources.UpdateScheduleResource;

public record UpdateScheduleCommand(
        Long scheduleId,
        String technicianId,
        String day,
        String startTime,
        String endTime
) {}

