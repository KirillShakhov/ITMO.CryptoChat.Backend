package ru.itmo.cryptochat.server.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.cryptochat.server.dto.NotifyDto;
import ru.itmo.cryptochat.server.services.NotifyService;


@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/v1/notify")
public class NotifyController {
    private final NotifyService notifyService;

    @PostMapping
    public ResponseEntity<String> notifications(@Valid @RequestBody NotifyDto notifyDto) {
        return new ResponseEntity<>(notifyService.notifications(notifyDto.recipient), HttpStatus.OK);
    }
}
