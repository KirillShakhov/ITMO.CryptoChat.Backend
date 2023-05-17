package ru.itmo.cryptochat.server.dto;
import javax.validation.constraints.NotBlank;

public class MessageDto {
    @NotBlank(message = "uuid not found")
    public String uuid;
    @NotBlank(message = "recipient not found")
    public String recipient;
    @NotBlank(message = "data not found")
    public String data;
    @NotBlank(message = "pass not found")
    public String pass;
}
