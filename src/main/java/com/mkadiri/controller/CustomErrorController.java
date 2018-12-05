package com.mkadiri.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping(path="/error")
    public @ResponseBody ResponseEntity error (HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String message = (String) request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        HashMap<String, String> error = new HashMap<>();
        error.put("error", message);

        return new ResponseEntity<Object>(error, HttpStatus.valueOf(statusCode));
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}