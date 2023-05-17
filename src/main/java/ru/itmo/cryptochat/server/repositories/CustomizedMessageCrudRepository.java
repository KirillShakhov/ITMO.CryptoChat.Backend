package ru.itmo.cryptochat.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.cryptochat.server.entities.Message;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomizedMessageCrudRepository extends JpaRepository<Message, UUID> {
    List<Message> findByRecipientAndPass(UUID recipient, String pass);
    List<Message> findByRecipient(UUID recipient);
    Integer deleteByUuidAndPass(UUID uuid, String pass);
    Long countByRecipient(UUID uuid);
}
