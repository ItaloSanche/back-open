package com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources;

public record ScheduleResource(
        Long id,
        String technicianId,
        String day,
        String startTime,
        String endTime
) {}
