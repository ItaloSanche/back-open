package com.electrolink.platform.service_platform_parent.sdp.application.internal.queryservices;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.Request;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindRequestByIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindRequestsByClientIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.RequestQueryService;
import com.electrolink.platform.service_platform_parent.sdp.infrastructure.persistence.jpa.repositories.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestQueryServiceImpl implements RequestQueryService {

    private final RequestRepository requestRepository;

    public RequestQueryServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Optional<Request> handle(FindRequestByIdQuery query) {
        return requestRepository.findById(query.requestId());
    }

    @Override
    public List<Request> handle(FindRequestsByClientIdQuery query) {
        return requestRepository.findByClientId(query.clientId());
    }
}
