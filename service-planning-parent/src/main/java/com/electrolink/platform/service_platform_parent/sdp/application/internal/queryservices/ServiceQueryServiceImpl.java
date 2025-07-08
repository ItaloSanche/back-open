package com.electrolink.platform.service_platform_parent.sdp.application.internal.queryservices;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ServiceEntity;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindServiceByIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.ServiceQueryService;
import com.electrolink.platform.service_platform_parent.sdp.infrastructure.persistence.jpa.repositories.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceQueryServiceImpl implements ServiceQueryService {

    private final ServiceRepository serviceRepository;

    public ServiceQueryServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Optional<ServiceEntity> handle(FindServiceByIdQuery query) {
        return serviceRepository.findById(query.serviceId());
    }
}
