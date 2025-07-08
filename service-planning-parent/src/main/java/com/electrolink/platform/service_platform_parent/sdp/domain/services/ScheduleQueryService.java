package com.electrolink.platform.service_platform_parent.sdp.domain.services;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ScheduleAggregate;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindSchedulesByTechnicianIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindScheduleByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ScheduleQueryService {
    Optional<ScheduleAggregate> handle(FindScheduleByIdQuery query);
    List<ScheduleAggregate> handle(FindSchedulesByTechnicianIdQuery query);
}
