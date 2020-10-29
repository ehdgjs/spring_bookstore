package com.project.bookstore.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ApiResponse
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private Boolean result;
    private String msg;
    private Object data;

}