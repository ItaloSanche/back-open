package com.electrolink.platform.service_platform_parent.sdp.domain.services;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.CreateServiceCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.UpdateServiceCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.DeleteServiceCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ServiceEntity;

public interface ServiceCommandService {
    Long handle(CreateServiceCommand command);
    void handle(UpdateServiceCommand command);
    void handle(DeleteServiceCommand command);
}
