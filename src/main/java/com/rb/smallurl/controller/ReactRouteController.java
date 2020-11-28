package com.rb.smallurl.controller;


import com.rb.smallurl.exception.BadRequestException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ReactRouteController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }
    @GetMapping(value = "/error")
    public String routes() {
        return "error";
    }

}