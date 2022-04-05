package com.example.springvalidationexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "User name should not be null")
    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile Number")
    private String mobile;

    private String gender;

    @Min(18)
    @Max(60)
    private Integer age;

    @NotNull
    @NotBlank
    private String nationality;
}
