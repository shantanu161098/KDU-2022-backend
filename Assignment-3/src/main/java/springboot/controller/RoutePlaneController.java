package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springboot.dto.RoutePlaneDTO;
import springboot.entity.RoutePlane;
import springboot.repository.RoutePlaneRepository;
import springboot.service.RoutePlaneService;

@RestController
@RequestMapping("/routePlane")
public class RoutePlaneController {
    @Autowired
    RoutePlaneService routePlaneService;

    @Autowired
    RoutePlaneRepository routePlaneRepository;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(AirlineController.class);


    @PostMapping("/add")
    public RoutePlane addRoutePlane(@RequestBody RoutePlane routePlane){
        logger.info("adding route");
        return routePlaneRepository.save(routePlane);
    }

    @GetMapping("/{id}")
    public RoutePlaneDTO getById(@PathVariable String id) {
        logger.info("Get by id");
        return routePlaneService.findByRouteID(id);
    }
}
