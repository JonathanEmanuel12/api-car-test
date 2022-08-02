package com.selecao.prova.cars.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.selecao.prova.cars.models.Car;
import com.selecao.prova.cars.models.CarLog;
import com.selecao.prova.cars.repositories.CarLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class CarService {

    @Autowired
    private CarLogRepository carLogRepository;

    private static final String URI = "http://api-test.bhut.com.br:3000/api/cars";

    public List<Car> findAllCars() {
        RestTemplate rest = new RestTemplate();
        Car[] resultArray = rest.getForObject(URI, Car[].class);

        List<Car> result = null;
        if(resultArray != null) {
            result = Arrays.asList(resultArray);
            result.sort(Comparator.comparing((Car car) -> car.getTitle().toLowerCase(), Comparator.naturalOrder()));
        }

        return result;
    }

    public String saveCar(Car car) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Car> request = new HttpEntity<Car>(car);
        String resultJson = restTemplate.postForObject(URI, request, String.class);

        HashMap<String, Object> mapCar = new ObjectMapper().readValue(resultJson, HashMap.class);
        this.saveCarLog(new CarLog(mapCar.get("title").toString(), mapCar.get("_id").toString()));

        return resultJson;
    }

    public List<CarLog> findAllCarLogs() {
        return carLogRepository.findAll();
    }

    private void saveCarLog(CarLog carLog) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        carLog.setDateTime(dateTimeFormatter.format(LocalDateTime.now()));
        carLogRepository.insert(carLog);
    }
}
