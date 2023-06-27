package com.example.payrollapi.domain;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
// FAZER COMPARTIVOS DE PROPRIEDADES DA CLASSE
// SÓ CRIARA IMPLICITAMENTE O QUE FOR EXPLICITADO antes de cada propriedade
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User
{
    private Long id;
    private String name;
    private String email;
    private String password;
    private Double hourlyPrice;
}
