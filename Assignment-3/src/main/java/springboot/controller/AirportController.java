package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.dto.AirportDTO;
import springboot.service.AirplaneService;
import springboot.service.AirportService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(AirplaneController.class);

    private ResponseEntity<List<AirportDTO>> notFound() {
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/code/{code}")
    public AirportDTO getAirportByCOde(@PathVariable String code) {
        logger.info("Received a request to fetch airport with {}", code);
        return airportService.findByAirportCode(code);
    }

    @GetMapping("/city/{cityCode}")
    public ResponseEntity<List<AirportDTO>> getAirportByCity(@PathVariable String cityCode){
        logger.info("Received a request to fetch airport with {}", cityCode);
        return Optional.ofNullable(airportService.findByCityCode(cityCode))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(notFound());
    }

    @GetMapping("/country/{countryCode}")
    public ResponseEntity<List<AirportDTO>> getAirportByCountry(@PathVariable String countryCode){
        logger.info("Received a request to fetch airport with {}", countryCode);
        return Optional.ofNullable(airportService.findByCountryCode(countryCode))
                .map(a -> new ResponseEntity<>(a, HttpStatus.OK))
                .orElse(notFound());
    }
}
