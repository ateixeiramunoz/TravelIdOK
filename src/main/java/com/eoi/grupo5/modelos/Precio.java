package com.eoi.grupo5.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "idHabitacion", nullable = false)
    private Habitacion habitacion;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

}
