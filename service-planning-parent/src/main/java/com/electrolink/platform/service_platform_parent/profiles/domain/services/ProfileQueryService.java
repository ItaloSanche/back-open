package com.electrolink.platform.service_platform_parent.profiles.domain.services;


import com.electrolink.platform.service_platform_parent.profiles.domain.model.aggregates.Profile;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.queries.GetAllProfilesQuery;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.queries.GetProfileByAgeQuery;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.queries.GetProfileByEmailQuery;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.queries.GetProfilesByRoleQuery;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.queries.GetProfileByFullNameQuery;
import com.electrolink.platform.service_platform_parent.profiles.domain.model.queries.GetProfileByIdQuery;

import java.util.List;
import java.util.Optional;

public interface ProfileQueryService {
  List<Profile> handle(GetAllProfilesQuery query);
  Optional<Profile> handle(GetProfileByIdQuery query);
  Optional<Profile> handle(GetProfileByFullNameQuery query);
  Optional<Profile> handle(GetProfileByEmailQuery query);
  List<Profile> handle(GetProfilesByRoleQuery query);

  // Solo si sigues usando edad como campo
  List<Profile> handle(GetProfileByAgeQuery query);
}
