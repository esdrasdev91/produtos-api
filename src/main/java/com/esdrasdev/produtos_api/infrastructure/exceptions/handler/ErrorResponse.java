package com.esdrasdev.produtos_api.infrastructure.exceptions.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String mensagem;
    private LocalDateTime data;
    private int status;
    private String path;

}
