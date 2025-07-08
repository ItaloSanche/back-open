package com.electrolink.platform.service_platform_parent.iam.interfaces.rest.transform;

import com.electrolink.platform.service_platform_parent.iam.domain.model.commands.SignInCommand;
import com.electrolink.platform.service_platform_parent.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {

  public static SignInCommand toCommandFromResource(SignInResource signInResource) {
    return new SignInCommand(signInResource.username(), signInResource.password());
  }
}
