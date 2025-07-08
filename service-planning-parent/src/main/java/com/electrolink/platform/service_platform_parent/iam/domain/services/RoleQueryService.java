package com.electrolink.platform.service_platform_parent.iam.domain.services;

import com.electrolink.platform.service_platform_parent.iam.domain.model.entities.Role;
import com.electrolink.platform.service_platform_parent.iam.domain.model.queries.GetAllRolesQuery;
import com.electrolink.platform.service_platform_parent.iam.domain.model.queries.GetRoleByNameQuery;

import java.util.List;
import java.util.Optional;

public interface RoleQueryService {
  List<Role> handle(GetAllRolesQuery query);
  Optional<Role> handle(GetRoleByNameQuery query);
}
