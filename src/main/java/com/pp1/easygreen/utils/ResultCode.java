package com.pp1.easygreen.utils;

public enum ResultCode {
    SUCCESS(200, "Operation Succeed"),
    FAILED(500, "Operation Failed"),
    VALIDATE_FAILED(404, "Validation Failed"),
    UNAUTHORIZED(401, "Token is expired"),
    FORBIDDEN(403, "No permission");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
