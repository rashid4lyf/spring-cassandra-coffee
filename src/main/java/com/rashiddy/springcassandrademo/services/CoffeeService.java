package com.rashiddy.springcassandrademo.services;

import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.rashiddy.springcassandrademo.data.CoffeeRequest;
import com.rashiddy.springcassandrademo.models.CoffeeTypes;
import com.rashiddy.springcassandrademo.repository.CoffeeTypesRepository;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.stereotype.Service;

@Service
public class CoffeeService {

    private CoffeeTypesRepository coffeeTypesRepository;
    private CassandraOperations cassandraOperations;

    public CoffeeService(CoffeeTypesRepository coffeeTypesRepository, CassandraOperations cassandraOperations) {
        this.coffeeTypesRepository = coffeeTypesRepository;
        this.cassandraOperations = cassandraOperations;
    }

    public CoffeeTypes saveTutorial(CoffeeRequest coffeeRequest) {
        CoffeeTypes newItem = new CoffeeTypes(coffeeRequest.getName(), coffeeRequest.getDescription(), coffeeRequest.getImageUrl());
        cassandraOperations.insert(newItem, InsertOptions.builder()
                .consistencyLevel(ConsistencyLevel.LOCAL_QUORUM).build());
        return newItem;
    }
}
