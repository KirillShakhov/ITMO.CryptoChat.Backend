package ru.itmo.cryptochat.server.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itmo.cryptochat.server.dto.DeleteDto;
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
    public ResponseEntity<Boolean> createMessage(@Valid @RequestBody MessageDto messageDto){
        messageService.create(messageDto.recipient, messageDto.data, messageDto.pass);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Message>> findMessage(@NotBlank @RequestParam String recipient, @NotBlank @RequestParam String pass) {
        var list = messageService.find(recipient, pass);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteMessage(@Valid  @RequestBody DeleteDto deleteDto) {
        return new ResponseEntity<>(messageService.delete(deleteDto.uuid, deleteDto.pass), HttpStatus.OK);
    }
}
