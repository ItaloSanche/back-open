package com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources;

public record CreateScheduleResource(
        String technicianId,
        String day,
        String startTime,
        String endTime
) {}
