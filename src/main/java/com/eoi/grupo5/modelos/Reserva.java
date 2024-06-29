package com.eoi.grupo5.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
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

    @Column(name = "fechaReserva")
    private LocalDateTime fechaReserva;

    @Basic(optional = false)
    private boolean cancelado = false;

    @ManyToOne
    @JoinColumn(name = "idUsuario", foreignKey = @ForeignKey(name = "fk_reservas_usuarios"), nullable = false)
    private Usuario usu;

    @ManyToMany
    @JoinTable(
    name = "asientosReservados",
    joinColumns = @JoinColumn(name = "idReserva", foreignKey = @ForeignKey(name = "fk_asires_reservas")),
    inverseJoinColumns = @JoinColumn(name = "idAsiento", foreignKey = @ForeignKey(name = "fk_asires_asientos")))
    private Set<Asiento> asientos = new HashSet<>();

    @ManyToMany
    @JoinTable(
    name = "habitacionesReservadas",
    joinColumns = @JoinColumn(name = "idReserva", foreignKey = @ForeignKey(name = "fk_hreser_reservas")),
    inverseJoinColumns = @JoinColumn(name = "idHabitacion", foreignKey = @ForeignKey(name = "fk_hreser_habitaciones")))
    private Set<Habitacion> habitaciones = new HashSet<>();

    @ManyToMany
    @JoinTable(
    name = "actividadesReservadas",
    joinColumns = @JoinColumn(name = "idReserva", foreignKey = @ForeignKey(name = "fk_actres_reservas")),
    inverseJoinColumns = @JoinColumn(name = "idActividad", foreignKey = @ForeignKey(name = "fk_actres_actividades")))
    private Set<Actividad> actividades = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "idPago", referencedColumnName = "id", nullable = false)
    private Pago pago;

}
