package com.pp1.easygreen.controller;

import com.alibaba.fastjson.JSONObject;
import com.pp1.easygreen.entity.Organization;
import com.pp1.easygreen.service.OrganizationService;
import com.pp1.easygreen.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;

    @RequestMapping(value = "/organization", method = RequestMethod.GET)
    public CommonResult<List<Organization>> getAllOrganization() throws IOException {
        return CommonResult.success(organizationService.getAllOrganization());
    }

    // delete organization by user's selection
    @RequestMapping(value = "/organization/delete/{id}", method = RequestMethod.POST)
    public CommonResult<Long> deleteOrganizationBySelected(@PathVariable(name = "id") Long id) throws IOException {
        boolean organization = organizationService.deleteOrganization(id);
        if (organization == true) {
            return CommonResult.success(id);
        } else {
            return CommonResult.validateFailed("Delete unsuccessful");
        }
    }

    // create organization
    @RequestMapping(value = "/organization", method = RequestMethod.POST)
    public CommonResult<Organization> createOrganization(@RequestBody JSONObject param) throws IOException {
        Organization organization = param.toJavaObject(Organization.class);
        organization = new Organization(
                param.getString("name")
        );
        organization = organizationService.createOrganization(organization);
        if (organization == null) {
            return CommonResult.failed("Fail to create an organization");
        }
        if (organization.getId() == -1) {
            return CommonResult.failed("This organization is already existed");
        }
        return CommonResult.success(organization);
    }

    // update organization
    @RequestMapping(value = "/organization", method = RequestMethod.PUT)
    public CommonResult<String> updateOrganization(@RequestBody JSONObject param) throws IOException {
        Organization organization = new Organization(
                param.getLong("id"),
                param.getString("name")
        );
        organizationService.updateOrganization(organization);
        return CommonResult.success("Organization has been updated");
    }
}
