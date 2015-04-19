package com.jalarbee.lindo.domain;

import com.datastax.driver.core.DataType;
import lombok.*;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.Indexed;
import org.springframework.data.cassandra.mapping.PrimaryKey;

import java.util.*;

/**
 * @author Abdoulaye Diallo
 */

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
public class Organization extends AbstractEntity {

    @PrimaryKey
    private UUID id;

    @Column
    @Indexed(value = "name")
    private String name;

    @Column
    private Date joinDate;

    @Column
    @CassandraType(type = DataType.Name.SET, typeArguments = {DataType.Name.TEXT})
    private Set<String> requiredFields = new HashSet<>();

    @Column
    @CassandraType(type = DataType.Name.MAP, typeArguments = {DataType.Name.TEXT, DataType.Name.TEXT})
    private Map<String, String> rules = new HashMap<>();

}
