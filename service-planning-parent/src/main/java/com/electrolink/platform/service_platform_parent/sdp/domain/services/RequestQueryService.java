package com.electrolink.platform.service_platform_parent.sdp.domain.services;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.Request;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindRequestByIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindRequestsByClientIdQuery;

import java.util.List;
import java.util.Optional;

public interface RequestQueryService {
    Optional<Request> handle(FindRequestByIdQuery query);
    List<Request> handle(FindRequestsByClientIdQuery query);
}
