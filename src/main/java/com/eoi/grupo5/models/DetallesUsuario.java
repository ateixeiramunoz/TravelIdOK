package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalles_usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetallesUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "dni", length = 10)
    private String dni;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "contrasenya", length = 45)
    private String contrasenya;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario usu;

}
