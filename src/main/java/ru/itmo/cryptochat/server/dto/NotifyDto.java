package ru.itmo.cryptochat.server.dto;

import jakarta.validation.constraints.NotBlank;


public class NotifyDto {
    @NotBlank(message = "recipient not found")
    public String recipient;
}
