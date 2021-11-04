package com.pp1.easygreen.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.pp1.easygreen.entity.Organization;
import com.pp1.easygreen.mapper.OrganizationMapper;
import com.pp1.easygreen.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hang Yang
 * @date 03/11/2021 : 1:59 PM
 * @email s3799719@student.rmit.edu.au
 */

@Slf4j
@SpringBootTest
class OrganizationServiceImplTest {
    @Resource
    OrganizationService organizationService;

    @Resource
    OrganizationMapper organizationMapper;

    Organization generateRandomOrganization() {
        Organization organization = new Organization();
        organization.setId(RandomUtil.randomLong(10));
        organization.setName(RandomUtil.randomString(11));
        return organization;
    }

    @Test
    void getOrganizationById() {
        Organization o1 = generateRandomOrganization();
        assert organizationMapper.insert(o1) == 1;
        assert o1.getId() != null;

        Organization tmpP1 = organizationService.getOrganizationById(o1.getId());
        assert tmpP1.getId().equals(o1.getId());
        assert organizationMapper.deleteByPrimaryKey(o1.getId()) == 1;
    }

    @Test
    void getAllOrganization() {
        Organization o1 = generateRandomOrganization();
        Organization o2 = generateRandomOrganization();

        o1 = organizationService.createOrganization(o1);
        o2 = organizationService.createOrganization(o2);

        List<Organization> organizationList = organizationService.getAllOrganization();
        assert organizationList.size() >= 2;
        assert organizationMapper.deleteByPrimaryKey(o1.getId()) == 1;
        assert organizationMapper.deleteByPrimaryKey(o2.getId()) == 1;
    }

    @Test
    void deleteOrganization() {
        Organization o1 = generateRandomOrganization();
        o1 = organizationService.createOrganization(o1);
        assert organizationService.deleteOrganization(o1.getId());
    }

    @Test
    void createOrganization() {
        Organization organization = generateRandomOrganization();
        assert organizationService.createOrganization(organization).getId() != null;
        assert organizationMapper.deleteByPrimaryKey(organization.getId()) == 1;
    }

    @Test
    void updateOrganization() {
        Organization organization = new Organization();
        organization.setName("RMIT");
        organization = organizationService.createOrganization(organization);
        organization.setName("RMIT STUDENT UNION");
        assert organizationService.updateOrganization(organization) == 1;
        assert "RMIT STUDENT UNION".equals(organizationMapper.selectById(organization.getId()).getName());
        assert organizationMapper.deleteByPrimaryKey(organization.getId()) == 1;
    }
}