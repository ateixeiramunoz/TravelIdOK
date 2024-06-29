package com.eoi.grupo5.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombreUsuario", length = 45)
    private String nombreUsuario;

    @Column(name = "password", length = 45)
    private String password;

    @OneToOne(mappedBy = "usu",cascade = CascadeType.ALL)
    private DetallesUsuario detalles;

    @OneToMany(mappedBy = "usu")
    private Set<Reserva> reservas = new HashSet<>();

    @Basic(optional = false)
    private boolean active = true;

}
