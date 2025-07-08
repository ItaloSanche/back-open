package com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.transform;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ScheduleAggregate;
import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources.CreateScheduleResource;
import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources.ScheduleResource;
import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources.UpdateScheduleResource;

public class ScheduleMapper {

    public static ScheduleAggregate toModel(CreateScheduleResource resource) {
        return new ScheduleAggregate(
                resource.technicianId(),
                resource.day(),
                resource.startTime(),
                resource.endTime()
        );
    }

    public static ScheduleResource toResource(ScheduleAggregate model) {
        return new ScheduleResource(
                model.getId(),
                model.getTechnicianId(),
                model.getDay(),
                model.getStartTime(),
                model.getEndTime()
        );
    }

    public static void updateModel(ScheduleAggregate model, UpdateScheduleResource resource) {
        model.updateFrom(
                resource.day(),
                resource.startTime(),
                resource.endTime()
        );
    }
}
