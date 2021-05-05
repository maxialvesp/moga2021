package edu.unsj.fcefn.lcc.optimizacion.api.controllers;

import edu.unsj.fcefn.lcc.optimizacion.api.model.domain.FrameDTO;
import edu.unsj.fcefn.lcc.optimizacion.api.services.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/algorithm")
public class AlgorithmController {

    @Autowired
    AlgorithmService algorithmService;

    @GetMapping(value = "run")
    public List<FrameDTO> execute(){
        return algorithmService.excecute();
    }
}