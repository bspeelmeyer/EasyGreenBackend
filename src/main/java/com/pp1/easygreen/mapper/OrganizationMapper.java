package com.pp1.easygreen.mapper;

import com.pp1.easygreen.entity.Organization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrganizationMapper {
    List<Organization> selectAllOrganization();

    Organization selectById(Long organizationId);

    /**
     * This method corresponds to the database table location
     */
    int insert(Organization organizationRecord);

    /**
     * This method corresponds to the database table location
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method corresponds to the database table location
     */
    int updateByPrimaryKeySelective(Organization organization);
}
