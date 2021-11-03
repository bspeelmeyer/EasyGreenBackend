package com.pp1.easygreen.service.impl;

import com.pp1.easygreen.entity.Organization;
import com.pp1.easygreen.mapper.OrganizationMapper;
import com.pp1.easygreen.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    OrganizationMapper organizationMapper;

    @Override
    public List<Organization> getAllOrganization() {
        return organizationMapper.selectAllOrganization();
    }

    @Override
    public Organization getOrganizationById(Long organizationId) {
        return organizationMapper.selectById(organizationId);
    }

    @Override
    public boolean deleteOrganization(Long id) {
        if (organizationMapper.deleteByPrimaryKey(id) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Organization createOrganization(Organization organization) {
        if (organizationMapper.insert(organization) > 0) {
            return organization;
        }
        return null;
    }

    @Override
    public int updateOrganization(Organization organization) {
        return organizationMapper.updateByPrimaryKeySelective(organization);
    }

}
