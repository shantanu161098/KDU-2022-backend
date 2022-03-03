package springboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="airports")
public class Airport {
    @Id
    @Column(name = "code")
    private String airportCode;

    @Column(name="city_code")
    private String cityCode;

    @Column(name="country_code")
    private String countryCode;

    @Column(name = "airport_name")
    private String airportName;
}
