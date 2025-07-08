package com.electrolink.platform.service_platform_parent.iam.domain.services;

import com.electrolink.platform.service_platform_parent.iam.domain.model.aggregates.User;
import com.electrolink.platform.service_platform_parent.iam.domain.model.queries.GetAllUsersQuery;
import com.electrolink.platform.service_platform_parent.iam.domain.model.queries.GetUserByIdQuery;
import com.electrolink.platform.service_platform_parent.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
  List<User> handle(GetAllUsersQuery query);
  Optional<User> handle(GetUserByIdQuery query);
  Optional<User> handle(GetUserByUsernameQuery query);
}
