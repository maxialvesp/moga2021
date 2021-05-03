package edu.unsj.fcefn.lcc.optimizacion.api.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrameDTO {
	private Integer id;
	private Integer idTransportCompany;
	private Integer idStopDeparture;
	private Integer idStopArrival;
	private Float price;
	private String category;
	private LocalTime departureDatetime;
	private LocalTime arrivalDatetime;
}
