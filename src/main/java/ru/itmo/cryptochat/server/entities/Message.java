package ru.itmo.cryptochat.server.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "messages")
public class Message {
    @Id
    public UUID uuid;
    public UUID recipient;
    public String data;
    public String pass;
    public Date createdDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(uuid, message.uuid) && Objects.equals(recipient, message.recipient) && Objects.equals(data, message.data) && Objects.equals(pass, message.pass) && Objects.equals(createdDate, message.createdDate);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
