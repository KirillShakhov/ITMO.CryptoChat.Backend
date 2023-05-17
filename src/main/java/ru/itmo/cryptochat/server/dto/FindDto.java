package ru.itmo.cryptochat.server.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FindDto {
    @NotBlank(message = "recipient not found")
    public String recipient;
    @NotBlank(message = "pass not found")
    public String pass;
}
