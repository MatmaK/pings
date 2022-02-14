package com.pingr.Pings.core.advices;

import com.pingr.Pings.core.exceptions.PingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PingNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String illegalArgumentHandler(PingNotFoundException ex) {
        return ex.getMessage();
    }
}