package com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources;

public record UpdateScheduleResource(
        String technicianId,
        String day,
        String startTime,
        String endTime
) {}
