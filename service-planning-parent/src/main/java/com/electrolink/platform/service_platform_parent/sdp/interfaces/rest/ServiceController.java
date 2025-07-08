package com.electrolink.platform.service_platform_parent.sdp.interfaces.rest;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ServiceEntity;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.CreateServiceCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.UpdateServiceCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.DeleteServiceCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindServiceByIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.ServiceCommandService;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.ServiceQueryService;
import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources.CreateServiceResource;
import com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.transform.ServiceMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/services")
public class ServiceController {

    private final ServiceCommandService commandService;
    private final ServiceQueryService queryService;

    public ServiceController(ServiceCommandService commandService, ServiceQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody CreateServiceResource resource) {
        CreateServiceCommand command = ServiceMapper.toCreateCommand(resource);
        Long id = commandService.handle(command);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{serviceId}")
    public ResponseEntity<?> update(@PathVariable Long serviceId, @RequestBody CreateServiceResource resource) {
        UpdateServiceCommand command = ServiceMapper.toUpdateCommand(serviceId, resource);
        commandService.handle(command);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{serviceId}")
    public ResponseEntity<?> delete(@PathVariable Long serviceId) {
        DeleteServiceCommand command = new DeleteServiceCommand(serviceId);
        commandService.handle(command);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceEntity> getById(@PathVariable Long serviceId) {
        var query = new FindServiceByIdQuery(serviceId);
        Optional<ServiceEntity> result = queryService.handle(query);
        return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
