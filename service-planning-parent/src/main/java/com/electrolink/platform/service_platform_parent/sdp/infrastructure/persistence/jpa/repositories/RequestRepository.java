package com.electrolink.platform.service_platform_parent.sdp.infrastructure.persistence.jpa.repositories;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByClientId(String clientId);
}
