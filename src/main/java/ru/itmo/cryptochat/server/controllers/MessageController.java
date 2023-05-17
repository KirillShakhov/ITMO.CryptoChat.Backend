package ru.itmo.cryptochat.server.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.cryptochat.server.dto.DeleteDto;
import ru.itmo.cryptochat.server.dto.FindDto;
import ru.itmo.cryptochat.server.dto.MessageDto;
import ru.itmo.cryptochat.server.entities.Message;
import ru.itmo.cryptochat.server.services.MessageService;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final MessageService messageService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> CreateMessage(@Valid @RequestBody MessageDto messageDto){
        messageService.Create(messageDto.uuid, messageDto.recipient, messageDto.data, messageDto.pass);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Message>> FindMessage(@Valid   @RequestBody FindDto findDto) {
        var list = messageService.Find(findDto.recipient, findDto.pass);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> DeleteMessage(@Valid  @RequestBody DeleteDto deleteDto) {
        return new ResponseEntity<>(messageService.Delete(deleteDto.uuid, deleteDto.pass), HttpStatus.OK);
    }
}
