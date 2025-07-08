package com.electrolink.platform.service_platform_parent.sdp.domain.services;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.CreateScheduleCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.UpdateScheduleCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.DeleteScheduleCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ScheduleAggregate;

public interface ScheduleCommandService {
    Long handle(CreateScheduleCommand command);
    void handle(UpdateScheduleCommand command);
    void handle(DeleteScheduleCommand command);
}
