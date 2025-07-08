package com.electrolink.platform.service_platform_parent.sdp.infrastructure.persistence.jpa.repositories;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
