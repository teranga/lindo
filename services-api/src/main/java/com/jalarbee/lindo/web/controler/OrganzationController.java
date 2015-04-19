package com.jalarbee.lindo.web.controler;

import com.jalarbee.lindo.dto.Organization;
import com.jalarbee.lindo.service.OrganizationService;
import com.jalarbee.lindo.web.converter.EntityDtoConverters;
import com.jalarbee.lindo.web.resource.OrganizationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Abdoulaye Diallo
 */

@RestController
@RequestMapping("/api/organizations")
public class OrganzationController {

    @Autowired private OrganizationService organizationService;

    @RequestMapping(method = RequestMethod.GET)
    public Resources<OrganizationResource> allOrgs() {
        return new Resources<>(organizationService.findAll().map(EntityDtoConverters.ORGANIZATION_CONVERTER::convert).map(OrganizationResource::new).collect(Collectors.toList()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Resource<Organization> orgById(@PathVariable String id) {
        return new Resource<>(EntityDtoConverters.ORGANIZATION_CONVERTER.convert(organizationService.getOrganization(UUID.fromString(id))));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Resource<Organization> create(@RequestParam Organization dto) {
        return new Resource<>(EntityDtoConverters.ORGANIZATION_CONVERTER.convert(organizationService.create(dto.getName(), new Date(), dto.getRequiredFields(), dto.getRules()))); //TODO fix the date
    }
}
