package com.example.employee.enums;

public enum ResponseInfoEnum {
    REQUEST_SUCCESSFULLY(200, "ok", "Request successfully"),
    SERVER_INTERNAL_ERROR(500, "error", "Server internal error");

    private Integer code;
    private String message;
    private String description;

    ResponseInfoEnum(Integer code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }
}
