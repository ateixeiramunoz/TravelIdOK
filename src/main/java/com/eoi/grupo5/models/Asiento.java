package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "asientos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "numero", length = 5)
    private String numero;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "idCategoria", foreignKey = @ForeignKey(name = "fk_asi_cat"), nullable = false)
    private CategoriaAsiento categoria;

    @ManyToMany(mappedBy = "asientos")
    private Set<Reserva> reservas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idVuelo", foreignKey = @ForeignKey(name = "fk_asi_vuelos"), nullable = false)
    private Vuelo vuelo;

    public Asiento(String numero, Double precio) {
        this.numero = numero;
        this.precio = precio;
    }

}
