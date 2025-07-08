package com.electrolink.platform.service_platform_parent.sdp.domain.model.commands;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.entities.ComponentQuantity;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.entities.Tag;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.valueobjects.Policy;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.valueobjects.Restriction;

import java.util.List;

public record CreateServiceCommand(
        String name,
        String description,
        Double price,
        String estimatedTime,
        String category,
        boolean isVisible,
        String createdBy,
        Policy policy,
        Restriction restriction,
        List<Tag> tags,
        List<ComponentQuantity> components
) {}
