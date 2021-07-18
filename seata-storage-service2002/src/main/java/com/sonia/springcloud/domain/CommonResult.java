package com.sonia.springcloud.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String messgae;
    private T data;

    public CommonResult(Integer code, String messgae) {
        this(code,messgae,null);
    }
}
