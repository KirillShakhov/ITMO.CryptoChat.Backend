package ru.itmo.cryptochat.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.cryptochat.server.dto.FindDto;
import ru.itmo.cryptochat.server.dto.MessageDto;
import ru.itmo.cryptochat.server.entities.Message;
import ru.itmo.cryptochat.server.services.MessageService;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MessageController {
    private final MessageService messageService;

    @PostMapping(value = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> CreateMessage(@Valid @RequestBody MessageDto messageDto){
        messageService.Create(messageDto.uuid, messageDto.recipient, messageDto.data, messageDto.pass);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Message>> FindMessage(@Valid @RequestBody FindDto findDto) {
        var list = messageService.Find(findDto.recipient, findDto.pass);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
