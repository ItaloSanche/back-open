package com.electrolink.platform.service_platform_parent.sdp.application.internal.queryservices;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ScheduleAggregate;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindScheduleByIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.queries.FindSchedulesByTechnicianIdQuery;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.ScheduleQueryService;
import com.electrolink.platform.service_platform_parent.sdp.infrastructure.persistence.jpa.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleQueryServiceImpl implements ScheduleQueryService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleQueryServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Optional<ScheduleAggregate> handle(FindScheduleByIdQuery query) {
        return scheduleRepository.findById(query.scheduleId());
    }

    @Override
    public List<ScheduleAggregate> handle(FindSchedulesByTechnicianIdQuery query) {
        return scheduleRepository.findByTechnicianId(query.technicianId());
    }
}
