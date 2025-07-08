package com.electrolink.platform.service_platform_parent.sdp.interfaces.rest.resources;

import java.util.List;

public record RestrictionResource(
        List<String> unavailableDistricts,
        List<String> forbiddenDays,
        boolean requiresSpecialCertification
) {}
