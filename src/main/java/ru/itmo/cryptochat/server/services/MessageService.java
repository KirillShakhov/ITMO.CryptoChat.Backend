package ru.itmo.cryptochat.server.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.itmo.cryptochat.server.dto.MessageDto;
import ru.itmo.cryptochat.server.dto.PageDto;
import ru.itmo.cryptochat.server.entities.Message;
import ru.itmo.cryptochat.server.exceptions.PageNotFoundException;
import ru.itmo.cryptochat.server.repositories.CustomizedMessageCrudRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final CustomizedMessageCrudRepository customizedMessageCrudRepository;
    private final HashService hashService;

    public void Create(String uuid, String recipient, String data, String pass) {
        var message = Message
                .builder()
                .uuid(UUID.fromString(uuid))
                .recipient(UUID.fromString(recipient))
                .data(data)
                .pass(hashService.sha256(pass))
                .createdDate(new Date())
                .build();
        customizedMessageCrudRepository.save(message);
    }

    public List<Message> Find(String recipient, String pass){
        return customizedMessageCrudRepository.findByRecipientAndPass(UUID.fromString(recipient), hashService.sha256(pass));
    }
}
