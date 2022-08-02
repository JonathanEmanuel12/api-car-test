package com.selecao.prova.cars.repositories;

import com.selecao.prova.cars.models.CarLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarLogRepository extends MongoRepository<CarLog, String> {
}
