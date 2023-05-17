package ru.itmo.cryptochat.server.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.cryptochat.server.entities.Message;
import ru.itmo.cryptochat.server.repositories.CustomizedMessageCrudRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final CustomizedMessageCrudRepository customizedMessageCrudRepository;
    private final HashService hashService;

    public void create(String uuid, String recipient, String data, String pass) {
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

    public List<Message> find(String recipient, String pass){
        return customizedMessageCrudRepository.findByRecipientAndPass(UUID.fromString(recipient), hashService.sha256(pass));
    }

    public boolean delete(String uuid, String pass) {
        return customizedMessageCrudRepository.deleteByUuidAndPass(UUID.fromString(uuid), hashService.sha256(pass)) > 0;
    }
}
