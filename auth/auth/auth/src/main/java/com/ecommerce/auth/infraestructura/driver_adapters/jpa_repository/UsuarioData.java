package com.ecommerce.auth.infraestructura.driver_adapters.jpa_repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@Data
public class UsuarioData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(length = 30, nullable = false, unique = true)
    private String email;
    private String password;
    private String telefono;
    private String role;
    private Integer edad;
}
