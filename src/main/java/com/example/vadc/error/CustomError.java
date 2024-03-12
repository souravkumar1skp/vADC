package com.example.vadc.error;

import lombok.Data;

@Data
public class CustomError {
    private Integer err_code;
    private String error_description;
}
