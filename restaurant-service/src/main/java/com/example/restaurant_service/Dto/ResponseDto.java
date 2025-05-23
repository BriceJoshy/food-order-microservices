package com.example.restaurant_service.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter @Setter @AllArgsConstructor
public class ResponseDto {
    private HttpStatus status;
    private Object message;

    public static ResponseDto getResponseDto(Object message, HttpStatus status) {
        return ResponseDto.builder()
                .message(message)
                .status(status)
                .build();
    }
}