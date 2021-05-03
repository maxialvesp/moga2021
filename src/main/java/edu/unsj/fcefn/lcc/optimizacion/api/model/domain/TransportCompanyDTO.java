package edu.unsj.fcefn.lcc.optimizacion.api.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportCompanyDTO {
    private Integer id;
    private String name;
    private String logo;
}
