package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "localizaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Localizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "codigo", length = 10)
    private String codigo;

    @OneToMany(mappedBy = "destino")
    private Set<Vuelo> vuelosOrigen;

    @OneToMany(mappedBy = "destino")
    private Set<Vuelo> vuelosDestino;

    @ManyToOne
    @JoinColumn(name = "id_pais", foreignKey = @ForeignKey(name = "fk_local_paises"), nullable = false)
    private Pais pais;

    @OneToMany(mappedBy = "localizacion")
    private Set<Hotel> hoteles;

    @OneToMany(mappedBy = "localizacion")
    private Set<Actividad> actividades;

}
