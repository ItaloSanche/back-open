package com.electrolink.platform.service_platform_parent.sdp.interfaces.acl;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.CreateRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.DeleteRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.UpdateRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindRequestByIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindRequestsByClientIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.RequestCommandService;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.RequestQueryService;
import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources.CreateRequestResource;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.Request;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SDPContextFacade {

    private final RequestCommandService requestCommandService;
    private final RequestQueryService requestQueryService;

    public SDPContextFacade(RequestCommandService requestCommandService, RequestQueryService requestQueryService) {
        this.requestCommandService = requestCommandService;
        this.requestQueryService = requestQueryService;
    }

    public Optional<Request> fetchRequestById(Long requestId) {
        var query = new FindRequestByIdQuery(requestId);
        return requestQueryService.handle(query);
    }

    public List<Request> fetchRequestsByClientId(String clientId) {
        var query = new FindRequestsByClientIdQuery(clientId);
        return requestQueryService.handle(query);
    }

    public Long createRequest(CreateRequestResource resource) {
        var command = new CreateRequestCommand(resource);
        return requestCommandService.handle(command).getId();
    }

    public Long updateRequest(Long requestId, CreateRequestResource resource) {
        var command = new UpdateRequestCommand(requestId, resource);
        return requestCommandService.handle(command).getId();
    }

    public void deleteRequest(Long requestId) {
        var command = new DeleteRequestCommand(requestId);
        requestCommandService.handle(command);
    }
}
