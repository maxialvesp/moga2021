package edu.unsj.fcefn.lcc.optimizacion.api.algorithm;

import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.FrameDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.StopDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.services.AlgorithmService;
import edu.unsj.fcefn.lcc.optimizacion.api.services.FramesService;
import org.moeaframework.core.Solution;
import org.moeaframework.core.Variable;
import org.moeaframework.core.variable.EncodingUtils;
import org.moeaframework.core.variable.Permutation;
import org.moeaframework.problem.AbstractProblem;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class RoutingProblem extends AbstractProblem {

    @Autowired
    AlgorithmService algorithmService;

    @Autowired
    FramesService framesService;

    public RoutingProblem(Integer numberOfVariables, Integer numberOfObjectives) {
        super(numberOfVariables, numberOfObjectives);
    }

    @Override
    public void evaluate(Solution solution) {
        solution.setObjective(0, totalPrice(solution.getVariable(0)));
        solution.setObjective(1, totalTime(solution.getVariable(0)));
    }

    private double totalPrice(Variable variable){
        Permutation permutation = (Permutation)variable;
        List<StopDTO> stops = algorithmService.getStops();

        double totalPrice = 0;

        for(int i = 0;i < permutation.size() - 1;i++){
            StopDTO departureStop = stops.get(permutation.get(i));
            StopDTO arrivalStop = stops.get(permutation.get(i + 1));

            List<FrameDTO> frames = framesService
                    .findByIdDepartureStopAndIdArrivalStop(departureStop.getId(), arrivalStop.getId());

            FrameDTO bestPriceFrame = frames
                    .stream()
                    .min(Comparator.comparing(FrameDTO::getPrice))
                    .orElse(null);

            if(Objects.isNull(bestPriceFrame)){
                return Double.MAX_VALUE;
            }

            totalPrice += bestPriceFrame.getPrice();
        }

        return totalPrice;
    }

    private double totalTime(Variable variable){
        List<StopDTO> stops = algorithmService.getStops();
        return 0.0;
    }

    @Override
    public Solution newSolution() {
        Solution solution = new Solution(1, 2);
        solution.setVariable(0, EncodingUtils.newPermutation(20));
        return solution;
    }
}
