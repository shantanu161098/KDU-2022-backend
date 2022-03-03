package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.dto.AirportDTO;
import springboot.dto.FlightInstanceDTO;
import springboot.entity.FlightInstance;
import springboot.repository.FlightInstanceRepository;
import springboot.service.FlightInstanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightInstanceController {

    @Autowired
    private FlightInstanceService flightService;

    @Autowired
    private FlightInstanceRepository flightInstanceRepository;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(AirlineController.class);

    private ResponseEntity<List<FlightInstanceDTO>> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    private FlightInstanceDTO getById(@PathVariable String id) {
        logger.info("Received a request to get flight with id: {}", id);
        return flightService.findByInstanceID(id);
    }


    @GetMapping("/route/{routeId}")
    public ResponseEntity<List<FlightInstanceDTO>> getByRouteId(@PathVariable String routeId){
        logger.info("Received a request to get flight with id: {}", routeId);
        return Optional.ofNullable(flightService.findByRouteID(routeId))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(notFound());
    }

    @PostMapping("/add")
    FlightInstance addFlightInstance(@RequestBody FlightInstance flightInstance){
        logger.info("Received a request to add flight {}", flightInstance);
        return flightInstanceRepository.save(flightInstance);
    }

    @GetMapping("/plane/{id}")
    public ResponseEntity<List<FlightInstanceDTO>> getByPlaneID(@PathVariable String id) {
        logger.info("Received a request to get plane with id: {}", id);
        return Optional.ofNullable(flightService.findByPlaneID(id))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(notFound());
    }

}
