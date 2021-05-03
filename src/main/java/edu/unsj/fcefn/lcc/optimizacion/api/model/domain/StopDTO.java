package edu.unsj.fcefn.lcc.optimizacion.api.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StopDTO {
	private Integer id;
	private String name;
	private String city;
	private String province;
	private String country;
	private String latitud;
	private String logitud;
	private Integer ranking;
}
