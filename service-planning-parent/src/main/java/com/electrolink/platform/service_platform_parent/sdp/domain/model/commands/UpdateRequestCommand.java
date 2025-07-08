package com.electrolink.platform.service_platform_parent.sdp.domain.model.commands;

import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources.CreateRequestResource;

public record UpdateRequestCommand(Long requestId, CreateRequestResource resource) {
}
