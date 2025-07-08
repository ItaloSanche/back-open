package com.electrolink.platform.service_platform_parent.sdp.infrastructure.persistence.jpa.repositories;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ScheduleAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<ScheduleAggregate, Long> {
    List<ScheduleAggregate> findByTechnicianId(String technicianId);
}
