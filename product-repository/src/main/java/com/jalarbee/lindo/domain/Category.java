package com.jalarbee.lindo.domain;

import lombok.*;

import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */
@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Category {

    private UUID organizationid;
    private String name;

}
