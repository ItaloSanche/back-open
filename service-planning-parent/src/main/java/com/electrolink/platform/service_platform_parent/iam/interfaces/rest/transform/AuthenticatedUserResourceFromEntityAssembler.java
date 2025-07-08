package com.electrolink.platform.service_platform_parent.iam.interfaces.rest.transform;

import com.electrolink.platform.service_platform_parent.iam.domain.model.aggregates.User;
import com.electrolink.platform.service_platform_parent.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {

  public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
    return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
  }
}
