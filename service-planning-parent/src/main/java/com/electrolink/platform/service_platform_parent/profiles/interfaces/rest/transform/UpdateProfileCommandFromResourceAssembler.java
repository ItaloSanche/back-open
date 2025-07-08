package com.electrolink.platform.service_platform_parent.profiles.interfaces.rest.transform;

import com.electrolink.platform.service_platform_parent.profiles.domain.model.commands.UpdateProfileCommand;
import com.electrolink.platform.service_platform_parent.profiles.interfaces.rest.resources.ProfileResource;

public class UpdateProfileCommandFromResourceAssembler {

  public static UpdateProfileCommand toCommandFromResource(Long profileId, ProfileResource resource) {
    return new UpdateProfileCommand(
      profileId,
      resource.firstName(),
      resource.lastName(),
      resource.email(),
      resource.street(),
      resource.role(),
      resource.additionalInfoOrCertification()
    );
  }
}
