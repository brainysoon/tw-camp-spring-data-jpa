package com.example.employee.util;

import com.example.employee.domain.Response;
import com.example.employee.enums.ResponseInfoEnum;

public class ResponseWrapper<T> {

    public static <T> Response<T> wrapResponse(ResponseInfoEnum responseInfoEnum, T data) {
        Response<T> response = new Response<>(responseInfoEnum);
        response.setData(data);
        return response;
    }
}