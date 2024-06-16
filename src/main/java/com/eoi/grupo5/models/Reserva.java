package com.eoi.grupo5.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_reservas_usuarios"))
    private Usuario usu;

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
