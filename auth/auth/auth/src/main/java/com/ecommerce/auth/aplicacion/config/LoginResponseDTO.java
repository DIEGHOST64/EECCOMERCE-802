package com.ecommerce.auth.aplicacion.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String email;
    private String nombre;
    private String role;
    private String mensaje;
}