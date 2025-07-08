package com.electrolink.platform.service_platform_parent.sdp.domain.services;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.Request;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.CreateRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.UpdateRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.DeleteRequestCommand;

public interface RequestCommandService {
    Request handle(CreateRequestCommand command);
    Request handle(UpdateRequestCommand command);
    void handle(DeleteRequestCommand command);
}
