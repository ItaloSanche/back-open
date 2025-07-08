package com.electrolink.platform.service_platform_parent.profiles.interfaces.acl;


import com.electrolink.platform.service_platform_parent.profiles.domain.model.commands.CreateProfileCommand;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.commands.DeleteProfileCommand;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.commands.UpdateProfileCommand;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.queries.GetProfileByIdQuery;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.valueobjects.Role;
import com.electrolink.platform.service_platform_parent.profiles.domain.services.ProfileCommandService;
import com.electrolink.platform.service_platform_parent.profiles.domain.services.ProfileQueryService;
import com.electrolink.platform.service_platform_parent.profiles.interfaces.rest.resources.ProfileResource;
import com.electrolink.platform.service_platform_parent.profiles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfilesContextFacade {

  private final ProfileCommandService profileCommandService;
  private final ProfileQueryService profileQueryService;

  public ProfilesContextFacade(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
    this.profileCommandService = profileCommandService;
    this.profileQueryService = profileQueryService;
  }

  public Optional<ProfileResource> fetchProfileById(Long profileId) {
    var query = new GetProfileByIdQuery(profileId);
    return profileQueryService.handle(query)
      .map(ProfileResourceFromEntityAssembler::toResourceFromEntity);
  }

  public Optional<ProfileResource> fetchProfileByEmail(String email) {
    var query = new GetProfileByEmailQuery(email);
    return profileQueryService.handle(query)
      .map(ProfileResourceFromEntityAssembler::toResourceFromEntity);
  }

  public Long fetchProfileIdByEmail(String email) {
    var optional = profileQueryService.handle(new GetProfileByEmailQuery(email));
    return optional.map(p -> p.getId()).orElse(0L);
  }

  public boolean existsProfileByEmailAndIdIsNot(String email, Long id) {
    var optional = profileQueryService.handle(new GetProfileByEmailQuery(email));
    return optional.isPresent() && !optional.get().getId().equals(id);
  }

  public Long createProfile(String firstName, String lastName, String email, String street, Role role, String infoOrCert) {
    var command = new CreateProfileCommand(firstName, lastName, email, street, role, infoOrCert);
    return profileCommandService.handle(command);
  }

  public Long updateProfile(Long id, String firstName, String lastName, String email, String street, Role role, String infoOrCert) {
    var command = new UpdateProfileCommand(id, firstName, lastName, email, street, role, infoOrCert);
    var optional = profileCommandService.handle(command);
    return optional.map(p -> p.getId()).orElse(0L);
  }

  public void deleteProfile(Long profileId) {
    profileCommandService.handle(new DeleteProfileCommand(profileId));
  }


}
