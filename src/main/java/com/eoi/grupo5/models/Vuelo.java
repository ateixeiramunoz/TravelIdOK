package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vuelos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fecha_salida")
    private LocalDateTime fechaSalida;

    @Column(name = "fecha_llegada")
    private LocalDateTime fechaLlegada;

    @Column(name = "precio")
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_compania", foreignKey = @ForeignKey(name = "fk_vuelos_companias"), nullable = false)
    private CompaniaVuelo compania;

    @ManyToOne
    @JoinColumn(name = "id_origen", foreignKey = @ForeignKey(name = "fk_vuelos_origen"), nullable = false)
    private Localizacion origen;

    @ManyToOne
    @JoinColumn(name = "id_destino", foreignKey = @ForeignKey(name = "fk_vuelos_destino"), nullable = false)
    private Localizacion destino;


    @OneToMany(mappedBy = "vuelo")
    private Set<Asiento> asientos = new HashSet<>();


}
