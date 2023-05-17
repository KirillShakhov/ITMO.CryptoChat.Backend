package ru.itmo.cryptochat.server.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MessageDto {
    @NotBlank(message = "uuid is required")
    public String uuid;
    @NotBlank(message = "recipient is required")
    public String recipient;
    @NotBlank(message = "data is required")
    public String data;
    @NotBlank(message = "pass is required")
    public String pass;
}
