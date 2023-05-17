package ru.itmo.cryptochat.server.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/v1/info")
public class InfoController {
    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> InfoServer() {
        return new ResponseEntity<>("crypto1.0", HttpStatus.OK);
    }
}