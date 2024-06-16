package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "habitaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="numero", nullable = false)
    private Integer numero;

    @Column(name="capacidad")
    private Byte capacidad;

    @Column(name = "numero_camas")
    private Byte numeroCamas;

    @ManyToOne
    @JoinColumn(name = "id_tipo", foreignKey = @ForeignKey(name = "fk_habitaciones_tipo"), nullable = false)
    private TipoHabitacion tipo;

    @ManyToOne
    @JoinColumn(name = "id_hotel", foreignKey = @ForeignKey(name = "fk_habitaciones_hoteles"), nullable = false)
    private Hotel hotel;

    @ManyToMany(mappedBy = "habitaciones")
    private Set<Reserva> reservas;



}
