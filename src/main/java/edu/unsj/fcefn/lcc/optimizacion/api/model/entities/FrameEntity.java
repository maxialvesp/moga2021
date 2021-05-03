package edu.unsj.fcefn.lcc.optimizacion.api.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "frames")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_transport_company")
    private Integer idTransportCompany;

    @Column(name ="id_stop_departure")
    private Integer idStopDeparture;

    @Column(name ="id_stop_arrival")
    private Integer idStopArrival;

    @Column(name ="price")
    private Float price;

    @Column(name ="category")
    private String category;

    @Column(name ="departure_datetime")
    private LocalTime departureDatetime;

    @Column(name ="arrival_datetime")
    private LocalTime arrivalDatetime;

}
