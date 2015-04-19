package com.jalarbee.lindo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Abdoulaye Diallo
 */

@EqualsAndHashCode(of = {"username", "eventType", "eventDate"})
@Data
@NoArgsConstructor
public class UserEvent {


    @NotNull
    private String username;

    @NotNull
    private EventType eventType;

    @NotNull
    private LocalDateTime eventDate;
    private Map<String, ByteBuffer> payload;

}
