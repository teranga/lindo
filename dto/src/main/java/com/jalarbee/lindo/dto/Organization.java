package com.jalarbee.lindo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Abdoulaye Diallo
 */
@EqualsAndHashCode(of = {"name"})
@Data
@NoArgsConstructor
public class Organization {

    @NotNull
    private String name;
    @NotNull
    private LocalDateTime joinDate;
    @NotNull
    private Set<String> requiredFields = new HashSet<>();
    @NotNull
    private Map<String, String> rules = new HashMap<>();

}
