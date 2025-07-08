package com.electrolink.platform.service_platform_parent.profiles.interfaces.rest.resources;


import com.electrolink.platform.service_platform_parent.profiles.domain.model.valueobjects.Role;

public record CreateProfileResource(
  String firstName,
  String lastName,
  String email,
  String street,
  Role role,
  String additionalInfoOrCertification
) {}

