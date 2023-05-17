package ru.itmo.cryptochat.server.dto;

import javax.validation.constraints.NotBlank;

public class FindDto {
    @NotBlank(message = "recipient not found")
    public String recipient;
    @NotBlank(message = "pass not found")
    public String pass;
}
