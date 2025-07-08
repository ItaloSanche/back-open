package com.electrolink.platform.service_platform_parent.profiles.domain.services;


import com.electrolink.platform.service_platform_parent.profiles.domain.model.aggregates.Profile;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.commands.CreateProfileCommand;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.commands.DeleteProfileCommand;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.commands.UpdateProfileCommand;

import java.util.Optional;

public interface ProfileCommandService {
  Long handle(CreateProfileCommand command);
  Optional<Profile> handle(UpdateProfileCommand command);
  void handle(DeleteProfileCommand command);
}
