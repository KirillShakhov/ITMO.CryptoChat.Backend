package ru.itmo.cryptochat.server.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.cryptochat.server.repositories.CustomizedMessageCrudRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotifyService {
    private final CustomizedMessageCrudRepository customizedMessageCrudRepository;
    private final HashService hashService;

    public String notifications(String uuid) {
        var messages = customizedMessageCrudRepository.findByRecipient(UUID.fromString(uuid));
        StringBuilder stringForHash = new StringBuilder(uuid);
        for (var message : messages) {
            stringForHash.append(message.uuid);
        }
        return hashService.sha256(stringForHash.toString());
    }
}
