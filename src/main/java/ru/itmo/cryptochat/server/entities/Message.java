package ru.itmo.cryptochat.server.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Message message = (Message) o;
        return getUuid() != null && Objects.equals(getUuid(), message.getUuid());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
