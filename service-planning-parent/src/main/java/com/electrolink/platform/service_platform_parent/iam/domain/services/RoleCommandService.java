package com.electrolink.platform.service_platform_parent.iam.domain.services;

import com.electrolink.platform.service_platform_parent.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
  void handle(SeedRolesCommand command);
}
