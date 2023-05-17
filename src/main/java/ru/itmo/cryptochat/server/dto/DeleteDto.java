package ru.itmo.cryptochat.server.dto;

import javax.validation.constraints.NotBlank;

public class DeleteDto {
    @NotBlank(message = "uuid not found")
    public String uuid;
    @NotBlank(message = "pass not found")
    public String pass;
}
