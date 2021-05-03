package edu.unsj.fcefn.lcc.optimizacion.api.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "stops")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @Column(name = "province")
    private String province;

    @Column(name = "country")
    private String country;

    @Column(name = "latitud")
    private String latitud;

    @Column(name = "logitud")
    private String logitud;

    @Column(name = "ranking")
    private Integer ranking;
}
