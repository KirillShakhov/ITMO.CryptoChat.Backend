package ru.itmo.cryptochat.server.dto;


import jakarta.validation.constraints.NotBlank;

public class DeleteDto {
    @NotBlank(message = "uuid is required")
    public String uuid;
    @NotBlank(message = "pass is required")
    public String pass;
}
