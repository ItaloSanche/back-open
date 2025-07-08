package com.electrolink.platform.service_platform_parent.sdp.domain.model.commands;

public record CreateScheduleCommand(
        String technicianId,
        String day,
        String startTime,
        String endTime
) {}
