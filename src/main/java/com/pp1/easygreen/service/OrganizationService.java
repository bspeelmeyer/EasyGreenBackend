package com.pp1.easygreen.service;

import com.pp1.easygreen.entity.Organization;

import java.util.List;

public interface OrganizationService {
    List<Organization> getAllOrganization();

    Organization getOrganizationById(Long organizationId);

    boolean deleteOrganization(Long id);

    Organization createOrganization(Organization organization);

    int updateOrganization(Organization organization);
}
