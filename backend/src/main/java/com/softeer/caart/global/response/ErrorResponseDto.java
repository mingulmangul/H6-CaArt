package com.softeer.caart.global.response;

import com.softeer.caart.global.ResultCode;
import lombok.Getter;

@Getter
public class ErrorResponseDto extends ResponseDto{
    private ErrorResponseDto(ResultCode resultCode){
        super(false, resultCode.getStatusCode(), resultCode.getMessage());
    }

    public static ErrorResponseDto of(ResultCode resultCode){
        return new ErrorResponseDto(resultCode);
    }
}