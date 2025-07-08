package com.electrolink.platform.service_platform_parent.iam.interfaces.rest.transform;

import com.electrolink.platform.service_platform_parent.iam.domain.model.entities.Role;
import com.electrolink.platform.service_platform_parent.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {

  public static RoleResource toResourceFromEntity(Role role) {
    return new RoleResource(role.getId(), role.getStringName());
  }
}
