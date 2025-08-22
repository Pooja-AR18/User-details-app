package com.userapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    private String userId;

    @NotBlank(message = "Username is required")
    private String username;
    private String dob;
    private int age;
    private String gender;

    @NotBlank(message = "Document required")
    private String document;

    @NotBlank(message = "Photo upload required")
    private String photo;

    @NotBlank(message = "Language is required")
    private String languages;

    private String permanentAddress;
    private String residentialAddress;
}
