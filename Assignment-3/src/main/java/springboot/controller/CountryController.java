package springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springboot.dto.CountryDTO;
import springboot.repository.CountryRepository;
import springboot.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @Value("${spring.application.name}")
    private static String applicationName;

    private final Logger logger = LoggerFactory.getLogger(AirlineController.class);

    @GetMapping("/code/{code}")
    public CountryDTO getByCode(@PathVariable String code) {
        logger.info("Received a request to get country with id: {}", code);
        return countryService.findByCountryCode(code);
    }
}
