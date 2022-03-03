package springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="city")
public class City {
    @Id
    @Column(name = "code")
    private String cityCode;

    @Column(name = "name")
    private String cityName;

    @Column(name = "city_code")
    private String countryCode;
}
