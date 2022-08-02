package com.selecao.prova.cars.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.selecao.prova.cars.models.Car;
import com.selecao.prova.cars.models.CarLog;
import com.selecao.prova.cars.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/listCars")
    public ResponseEntity<List<Car>> findAllCars() {
        List<Car> result = carService.findAllCars();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/createCar")
    public ResponseEntity<String> save(@RequestBody Car car)  {
        try{
            String resultJson = carService.saveCar(car);
            return ResponseEntity.status(HttpStatus.CREATED).body(resultJson);
        }
        catch (JsonProcessingException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }


    }

    @GetMapping("/logs")
    public ResponseEntity<List<CarLog>> findAllCarLogs() {
        List<CarLog> result = carService.findAllCarLogs();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
