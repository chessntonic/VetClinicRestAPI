package dev.patika.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    @NotEmpty(message = "name value can't be empty")
    private String name;
    @NotEmpty(message = "phone value can't be empty")
    private String phone;

    @Email
    @NotEmpty(message = "mail value can't be empty")
    private String mail;

    private String address;

    private String city;
}
