package com.jalarbee.lindo.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;

/**
 * @author  Abdoulaye Diallo
 */

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
public class Client extends AbstractEntity {

    @PrimaryKey
    private String id;

    @Column
    private String name;

    @Column
    private String type;


}
