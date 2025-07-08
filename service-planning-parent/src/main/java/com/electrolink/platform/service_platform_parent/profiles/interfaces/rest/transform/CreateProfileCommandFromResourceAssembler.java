package com.electrolink.platform.service_platform_parent.profiles.interfaces.rest.transform;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.commands.CreateProfileCommand;
import com.electrolink.platform.service_platform_parent.profiles.interfaces.rest.resources.CreateProfileResource;



public class CreateProfileCommandFromResourceAssembler {

  public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource) {
    return new CreateProfileCommand(
      resource.firstName(),
      resource.lastName(),
      resource.email(),
      resource.street(),
      resource.role(),
      resource.additionalInfoOrCertification()
    );
  }
}
