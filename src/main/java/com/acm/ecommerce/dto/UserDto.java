package com.acm.ecommerce.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String username;
    private String password;
    private String phone;
    private NameDto name;

    public void setName(String firstName, String lastName) {
        this.name = NameDto.builder()
                .firstname(firstName)
                .lastname(lastName)
                .build();
    }

    public String getFirstName() {
        return this.name.getFirstname();
    }

    public String getLastName() {
        return this.name.getLastname();
    }
}

@Data
@Builder
class NameDto {
    private String firstname;
    private String lastname;
}
