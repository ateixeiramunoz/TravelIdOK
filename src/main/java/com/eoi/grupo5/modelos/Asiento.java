package com.eoi.grupo5.modelos;

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
    @JoinColumn(name = "idCategoria", foreignKey = @ForeignKey(name = "fkAsiCat"), nullable = false)
    private CategoriaAsiento categoria;

    @ManyToMany(mappedBy = "asientos")
    private Set<Reserva> reservas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idVuelo", foreignKey = @ForeignKey(name = "fkAsiVuelos"), nullable = false)
    private Vuelo vuelo;

}
