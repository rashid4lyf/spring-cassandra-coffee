package com.rashiddy.springcassandrademo.repository;


import com.rashiddy.springcassandrademo.models.CoffeeTypes;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeTypesRepository extends CassandraRepository<CoffeeTypes, String> {

    CoffeeTypes findByEmail(String email);


}
