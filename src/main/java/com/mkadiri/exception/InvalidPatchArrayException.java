package com.mkadiri.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_GATEWAY, reason="Invalid room array")
public class InvalidPatchArrayException extends Exception{
}
