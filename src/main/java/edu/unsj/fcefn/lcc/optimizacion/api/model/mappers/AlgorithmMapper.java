package edu.unsj.fcefn.lcc.optimizacion.api.model.mappers;

import com.lowagie.text.ExceptionConverter;
import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.FrameDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.StopDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.model.entities.StopEntity;
import edu.unsj.fcefn.lcc.optimizacion.api.services.FramesService;
import org.moeaframework.core.variable.Permutation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AlgorithmMapper {

    @Autowired
    FramesService framesService;

    public List<FrameDTO> permutationToDTO(Permutation permutation, List<StopDTO> stops) {

        List<FrameDTO> route = new ArrayList<>();
        for(int i = 0;i < permutation.size() - 1;i++){
            Integer departureStopId = stops.get(i).getId();
            Integer arrivalStopId = stops.get(i + 1).getId();
            FrameDTO frame  = framesService
                    .findByIdDepartureStopAndIdArrivalStop(departureStopId, arrivalStopId)
                    .stream()
                    .findFirst()
                    .get();

            route.add(frame);
        }
        return route;
    }
}
