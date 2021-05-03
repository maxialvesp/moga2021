package edu.unsj.fcefn.lcc.optimizacion.api.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "transport_companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportCompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "logo")
    private String logo;
}
