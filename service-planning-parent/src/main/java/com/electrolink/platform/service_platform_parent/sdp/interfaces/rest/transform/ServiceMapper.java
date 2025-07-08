package com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.transform;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ServiceEntity;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.CreateServiceCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.UpdateServiceCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.entities.ComponentQuantity;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.entities.Tag;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.valueobjects.Policy;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.valueobjects.Restriction;
import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources.CreateServiceResource;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceMapper {

    public static ServiceEntity toModel(CreateServiceResource resource) {
        Policy policy = new Policy(resource.policy().cancellationPolicy(), resource.policy().termsAndConditions());
        Restriction restriction = new Restriction(
                resource.restriction().unavailableDistricts(),
                resource.restriction().forbiddenDays(),
                resource.restriction().requiresSpecialCertification()
        );
        List<Tag> tags = resource.tags().stream()
                .map(tag -> new Tag(tag.name()))
                .collect(Collectors.toList());

        List<ComponentQuantity> components = resource.components().stream()
                .map(comp -> new ComponentQuantity(comp.componentId(), comp.quantity()))
                .collect(Collectors.toList());

        return new ServiceEntity(
                resource.name(),
                resource.description(),
                resource.basePrice(),
                resource.estimatedTime(),
                resource.category(),
                resource.isVisible(),
                resource.createdBy(),
                policy,
                restriction,
                tags,
                components
        );
    }

    public static CreateServiceCommand toCreateCommand(CreateServiceResource resource) {
        Policy policy = new Policy(resource.policy().cancellationPolicy(), resource.policy().termsAndConditions());
        Restriction restriction = new Restriction(
                resource.restriction().unavailableDistricts(),
                resource.restriction().forbiddenDays(),
                resource.restriction().requiresSpecialCertification()
        );
        List<Tag> tags = resource.tags().stream()
                .map(tag -> new Tag(tag.name()))
                .collect(Collectors.toList());

        List<ComponentQuantity> components = resource.components().stream()
                .map(comp -> new ComponentQuantity(comp.componentId(), comp.quantity()))
                .collect(Collectors.toList());

        return new CreateServiceCommand(
                resource.name(),
                resource.description(),
                resource.basePrice(),
                resource.estimatedTime(),
                resource.category(),
                resource.isVisible(),
                resource.createdBy(),
                policy,
                restriction,
                tags,
                components
        );
    }

    public static UpdateServiceCommand toUpdateCommand(Long serviceId, CreateServiceResource resource) {
        Policy policy = new Policy(resource.policy().cancellationPolicy(), resource.policy().termsAndConditions());
        Restriction restriction = new Restriction(
                resource.restriction().unavailableDistricts(),
                resource.restriction().forbiddenDays(),
                resource.restriction().requiresSpecialCertification()
        );
        List<Tag> tags = resource.tags().stream()
                .map(tag -> new Tag(tag.name()))
                .collect(Collectors.toList());

        List<ComponentQuantity> components = resource.components().stream()
                .map(comp -> new ComponentQuantity(comp.componentId(), comp.quantity()))
                .collect(Collectors.toList());

        return new UpdateServiceCommand(
                serviceId,
                resource.name(),
                resource.description(),
                resource.basePrice(),
                resource.estimatedTime(),
                resource.category(),
                resource.isVisible(),
                resource.createdBy(),
                policy,
                restriction,
                tags,
                components
        );
    }
}
