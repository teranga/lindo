package com.jalarbee.lindo.web.resource;

import com.jalarbee.lindo.dto.Organization;
import com.jalarbee.lindo.web.controler.OrganzationController;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author Abdoulaye Diallo
 */

@Getter
public class OrganizationResource extends ResourceSupport {

    private final Organization organization;

    public OrganizationResource(Organization organization) {
        this.organization = organization;
        this.add(linkTo(OrganzationController.class).withRel("organizations"));
    }

}
