package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorias_asiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaAsiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    private List<Asiento> asientos;

}
