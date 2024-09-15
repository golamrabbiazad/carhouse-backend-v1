package com.golamrabbiazad.fullstackcarhouse.repository;

import com.golamrabbiazad.fullstackcarhouse.domain.Car;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Schema(hidden = true)
public interface CarRepository extends CrudRepository<Car, Long> {
    @Schema(hidden = true)
    List<Car> findByBrand(String brand);

    @Schema(hidden = true)
    List<Car> findByColor(String color);

    List<Car> findByModelYear(int modelYear);

    List<Car> findByBrandOrderByModelYearAsc(String brand);
}
