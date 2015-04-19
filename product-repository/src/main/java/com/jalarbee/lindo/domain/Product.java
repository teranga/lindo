package com.jalarbee.lindo.domain;

import com.jalarbee.lindo.domain.AbstractEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Abdoulaye Diallo
 */

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
public class Product extends AbstractEntity {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID organizationId;

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    @NotNull
    @Size(min = 3, max = 30)
    private String category;

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private UUID id;

    @Column
    @NotNull
    @Size(min = 3, max = 30)
    private String name;
    @Column
    private String description;
    @Column
    @NotNull
    private Date registrationDate;
    @Column
    private BigDecimal retailPrice;
    @Column
    private BigDecimal purchasePrice;
    @Column
    private Map<String, String> attributes = new HashMap<>();
    @Column
    private Set<String> otherCategories = new HashSet<>();
    @Column
    private Set<String> tags = new HashSet<>();

}
