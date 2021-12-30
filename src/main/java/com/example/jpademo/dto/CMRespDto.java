package com.example.jpademo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CMRespDto<T> {
    private Integer statusCode;
    private String msg;
    private T data;
}
