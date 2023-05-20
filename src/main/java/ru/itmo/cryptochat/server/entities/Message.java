package ru.itmo.cryptochat.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID uuid;
    public UUID recipient;
    @Column(columnDefinition="text")
    public String data;
    @JsonIgnore
    public String pass;
    @JsonIgnore
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
