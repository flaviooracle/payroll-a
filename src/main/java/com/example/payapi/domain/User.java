package com.example.payapi.domain;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User
{
    private Long id;
    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;
}
