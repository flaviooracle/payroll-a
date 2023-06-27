package com.example.payapi.resources.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class StandardError
{
    private LocalDateTime timesStamp;
    private String error;
    private Integer status;
    private String path;
}
