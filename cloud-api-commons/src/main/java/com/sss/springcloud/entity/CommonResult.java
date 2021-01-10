package com.sss.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CommonResult<T> {
    // 404 not found
    private Integer code;
    private String message;
    private T   data;

    public CommonResult(Integer code, String message){
        this(code, message, null);
    }

    public CommonResult(Integer code, String message, Object o) {
        this.code = code;
        this.message = message;
        this.data = (T) o;
    }




}
