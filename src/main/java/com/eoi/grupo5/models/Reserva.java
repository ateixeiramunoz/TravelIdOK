package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "estado_pago")
    private boolean estadoPago;

    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    @ManyToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_reservas_usuarios"), nullable = false)
    private Usuario usu;

    @ManyToMany
    @JoinTable(
    name = "asientos_reservados",
    joinColumns = @JoinColumn(name = "id_reserva", foreignKey = @ForeignKey(name = "fk_asires_reservas")),
    inverseJoinColumns = @JoinColumn(name = "id_asiento", foreignKey = @ForeignKey(name = "fk_asires_asientos")))
    private Set<Asiento> asientos;

    @ManyToMany
    @JoinTable(
    name = "habitaciones_reservadas",
    joinColumns = @JoinColumn(name = "id_reserva", foreignKey = @ForeignKey(name = "fk_hreser_reservas")),
    inverseJoinColumns = @JoinColumn(name = "id_habitacion", foreignKey = @ForeignKey(name = "fk_hreser_habitaciones")))
    private Set<Habitacion> habitaciones;

    @ManyToMany
    @JoinTable(
    name = "actividades_reservadas",
    joinColumns = @JoinColumn(name = "id_reserva", foreignKey = @ForeignKey(name = "fk_actres_reservas")),
    inverseJoinColumns = @JoinColumn(name = "id_actividad", foreignKey = @ForeignKey(name = "fk_actres_actividades")))
    private Set<Actividad> actividades;

    @OneToOne(mappedBy = "reserva")
    private Pago pago;

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", estadoPago=" + estadoPago +
                ", fechaReserva=" + fechaReserva +
                ", usu=" + usu.getNombre() +
                '}';
    }
}
