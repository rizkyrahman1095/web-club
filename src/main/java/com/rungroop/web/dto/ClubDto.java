package com.rungroop.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@Builder
public class ClubDto {
    private long id;
    @NotEmpty (message ="title should not be empty")
    private String title;
    @NotEmpty (message ="photo should not be empty")
    private String content;
    @NotEmpty (message ="content not be empty")
    private String photoUrl;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
}
