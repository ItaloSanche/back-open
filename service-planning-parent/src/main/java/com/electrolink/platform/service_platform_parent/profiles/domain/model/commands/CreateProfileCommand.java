package com.electrolink.platform.service_platform_parent.profiles.domain.model.commands;

import com.electrolink.platform.service_platform_parent.profiles.domain.model.valueobjects.Role;

public record CreateProfileCommand(
  String firstName,
  String lastName,
  String email,
  String street,
  Role role,
  String additionalInfoOrCertification
) {}

