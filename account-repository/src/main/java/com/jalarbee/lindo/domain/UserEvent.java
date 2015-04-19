package com.jalarbee.lindo.domain;

import com.datastax.driver.core.DataType;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Abdoulaye Diallo
 */

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
@ToString
public class UserEvent extends AbstractEntity {

    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String username;

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private UUID eventDate;

    @Column
    private String type;

    @Column
    @CassandraType(type = DataType.Name.MAP, typeArguments = {DataType.Name.TEXT, DataType.Name.BLOB})
    private Map<String, ByteBuffer> payload = new HashMap<>();



}
