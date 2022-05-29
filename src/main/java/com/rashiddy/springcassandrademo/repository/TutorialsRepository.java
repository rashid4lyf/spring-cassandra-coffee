package com.rashiddy.springcassandrademo.repository;


import com.rashiddy.springcassandrademo.models.TutorialTable;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialsRepository extends CassandraRepository<TutorialTable, String> {

    TutorialTable findByEmail(String email);


}
