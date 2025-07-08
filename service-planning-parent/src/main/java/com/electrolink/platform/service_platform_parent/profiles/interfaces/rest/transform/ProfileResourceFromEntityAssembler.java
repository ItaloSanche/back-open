package com.electrolink.platform.service_platform_parent.profiles.interfaces.rest.transform;

import com.electrolink.platform.service_platform_parent.profiles.domain.model.aggregates.Profile;
import com.electrolink.platform.service_platform_parent.profiles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {

  public static ProfileResource toResourceFromEntity(Profile entity) {
    String info = null;
    switch (entity.getRole()) {
      case HOMEOWNER -> {
        if (entity.getHomeOwner() != null)
          info = entity.getHomeOwner().getAdditionalInfo();
      }
      case TECHNICIAN -> {
        if (entity.getTechnician() != null)
          info = entity.getTechnician().getCertificationCode();
      }
    }

    return new ProfileResource(
      entity.getId(),
      entity.getPersonName().firstName(),
      entity.getPersonName().lastName(),
      entity.getEmail().address(),
      entity.getAddress().street(),
      entity.getRole(),
      info
    );
  }
}
