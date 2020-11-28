package com.rb.smallurl.controller;

import com.rb.smallurl.dto.RedirectRequestDto;
import com.rb.smallurl.entity.Redirect;
import com.rb.smallurl.service.RedirectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;

@RestController
public class RedirectController {

    private final RedirectService service;

    public RedirectController(RedirectService service) {
        this.service = service;
    }

    @PostMapping("/api/create")
    public ResponseEntity<?> createRedirect(@Valid @RequestBody RedirectRequestDto redirectDto) {
        return ResponseEntity.ok(service.createRedirect(redirectDto));
    }

    @GetMapping("/{alias}")
    public void redirectRequest(@PathVariable String alias, HttpServletResponse resp) throws IOException {
        Redirect redirect = service.getRedirect(alias);
        resp.sendRedirect(redirect.getUrl());
    }

}
