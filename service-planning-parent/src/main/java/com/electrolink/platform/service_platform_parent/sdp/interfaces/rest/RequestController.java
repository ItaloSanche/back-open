package com.electrolink.platform.service_platform_parent.sdp.interfaces.rest;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.Request;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.CreateRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.DeleteRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.UpdateRequestCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindRequestByIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindRequestsByClientIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.RequestCommandService;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.RequestQueryService;
import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources.CreateRequestResource;
import com.electrolink.platform.service_platform_parent.shared.interfaces.rest.resources.MessageResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/requests")
public class RequestController {

    private final RequestCommandService requestCommandService;
    private final RequestQueryService requestQueryService;

    public RequestController(RequestCommandService requestCommandService,
                             RequestQueryService requestQueryService) {
        this.requestCommandService = requestCommandService;
        this.requestQueryService = requestQueryService;
    }

    @PostMapping
    public ResponseEntity<MessageResource> createRequest(@RequestBody CreateRequestResource resource) {
        var command = new CreateRequestCommand(resource);
        Request savedRequest = requestCommandService.handle(command);
        return new ResponseEntity<>(new MessageResource("Request created with ID: " + savedRequest.getId()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
        var query = new FindRequestByIdQuery(id);
        return requestQueryService.handle(query)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/clients/{clientId}/requests")
    public ResponseEntity<List<Request>> getRequestsByClient(@PathVariable String clientId) {
        var query = new FindRequestsByClientIdQuery(clientId);
        return ResponseEntity.ok(requestQueryService.handle(query));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResource> updateRequest(@PathVariable Long id, @RequestBody CreateRequestResource resource) {
        var command = new UpdateRequestCommand(id, resource);
        requestCommandService.handle(command);
        return ResponseEntity.ok(new MessageResource("Request updated successfully."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResource> deleteRequest(@PathVariable Long id) {
        var command = new DeleteRequestCommand(id);
        requestCommandService.handle(command);
        return ResponseEntity.ok(new MessageResource("Request deleted successfully."));
    }
}
