package com.electrolink.platform.service_platform_parent.sdp.domain.services;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ServiceEntity;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindServiceByIdQuery;

import java.util.Optional;

public interface ServiceQueryService {
    Optional<ServiceEntity> handle(FindServiceByIdQuery query);
}
