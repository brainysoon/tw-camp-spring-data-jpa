package com.example.employee.util;

import com.example.employee.domain.Response;
import com.example.employee.enums.ResponseInfoEnum;

import java.util.function.Predicate;

public class ResponseWrapper<T> {

    public static <T> Response<T> wrapResponse(ResponseInfoEnum responseInfoEnum, T data) {
        Response<T> response = new Response<>(responseInfoEnum);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> wrapGetResponse(Predicate<T> emptyPredicate, T data) {
        ResponseInfoEnum responseInfoEnum = emptyPredicate.test(data) ?
                ResponseInfoEnum.RESOURCE_NOT_FOUND : ResponseInfoEnum.REQUEST_SUCCESSFULLY;

        Response<T> response = new Response<>(responseInfoEnum);
        response.setData(data);
        return response;
    }
}