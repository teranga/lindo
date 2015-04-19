package com.jalarbee.lindo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Abdoulaye Diallo
 */
@EqualsAndHashCode(of = {"username", "organization", "reviewDate", "rating"})
@Data
@NoArgsConstructor
public class Review {

    @NotNull
    private String username;
    @NotNull
    private String organization;
    @NotNull
    private String review;
    @NotNull
    private LocalDateTime reviewDate;
    private int rating;
}
