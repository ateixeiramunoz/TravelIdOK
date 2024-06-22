package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hoteles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "categoria")
    private Byte categoria;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @Column(name = "contacto", length = 45)
    private String contacto;

    @Column(name = "precio")
    private Double precio;

    @OneToMany(mappedBy = "hotel")
    private Set<Habitacion> habitaciones = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idLocalizacion", foreignKey = @ForeignKey(name = "fk_hoteles_local"), nullable = false)
    private Localizacion localizacion;

}
