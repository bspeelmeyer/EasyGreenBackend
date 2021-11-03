package com.pp1.easygreen.controller;

import com.pp1.easygreen.entity.Organization;
import com.pp1.easygreen.service.OrganizationService;
import com.pp1.easygreen.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
