package com.golamrabbiazad.fullstackcarhouse.web;

import com.golamrabbiazad.fullstackcarhouse.domain.Car;
import com.golamrabbiazad.fullstackcarhouse.domain.CarRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Schema(hidden = true)
@Tag(name="Car", description = "the car api")
@RestController
@RequestMapping("/api/v1")
public class CarController {
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @Operation(
            summary = "Fetch all cars",
            description = "fetches all cars entities and their data from data source",
            method = "GET",
            security = { @SecurityRequirement(name = "Bearer Authentication") }
    )
    @GetMapping("/cars")
    public Iterable<Car> getCars() {
        return repository.findAll();
    }
}
