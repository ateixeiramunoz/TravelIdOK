package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "actividades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 45)
    private String nombre;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDateTime fechaFin;

    @ManyToOne
    @JoinColumn(name = "id_tipo", foreignKey = @ForeignKey(name = "fk_acti_tipo"), nullable = false)
    private TipoActividad tipo;

    @ManyToMany(mappedBy = "actividades")
    private Set<Reserva> reservas;

    @ManyToOne
    @JoinColumn(name = "id_localizacion", foreignKey = @ForeignKey(name = "fk_actividades_local"), nullable = false)
    private Localizacion localizacion;

}
