package com.electrolink.platform.service_platform_parent.sdp.application.internal.commandservices;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.Request;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.CreateRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.UpdateRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.DeleteRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.RequestCommandService;
import com.electrolink.platform.service_platform_parent.sdp.infrastructure.persistence.jpa.repositories.RequestRepository;
import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.transform.RequestMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RequestCommandServiceImpl implements RequestCommandService {

    private final RequestRepository requestRepository;

    public RequestCommandServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    @Transactional
    public Request handle(CreateRequestCommand command) {
        return requestRepository.save(RequestMapper.toModel(command.resource()));
    }

    @Override
    @Transactional
    public Request handle(UpdateRequestCommand command) {
        return requestRepository.findById(command.requestId())
                .map(existing -> {
                    existing.updateFrom(command.resource());
                    return requestRepository.save(existing);
                })
                .orElseThrow(() -> new IllegalArgumentException("Request not found"));
    }

    @Override
    @Transactional
    public void handle(DeleteRequestCommand command) {
        var request = requestRepository.findById(command.requestId())
                .orElseThrow(() -> new IllegalArgumentException("Request not found"));
        requestRepository.delete(request);
    }
}
