package com.examplepractice.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StandardResponse {
    private int statusCode;
    private String statusMessage;
    private Object data;
}
