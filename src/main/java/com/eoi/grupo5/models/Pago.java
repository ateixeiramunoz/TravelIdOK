package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "importe")
    private Double importe;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reserva", referencedColumnName = "id", nullable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago", foreignKey = @ForeignKey(name = "fk_pagos_metodos"), nullable = false)
    private MetodosPago metodoPago;
}
