package com.rashiddy.springcassandrademo.services;

import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.rashiddy.springcassandrademo.data.TutorialRequest;
import com.rashiddy.springcassandrademo.models.TutorialTable;
import com.rashiddy.springcassandrademo.repository.TutorialsRepository;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.stereotype.Service;

@Service
public class TutorialCassandraService {

    private TutorialsRepository tutorialsRepository;
    private CassandraOperations cassandraOperations;

    public TutorialCassandraService(TutorialsRepository tutorialsRepository, CassandraOperations cassandraOperations) {
        this.tutorialsRepository = tutorialsRepository;
        this.cassandraOperations = cassandraOperations;
    }

    public TutorialTable saveTutorial(TutorialRequest tutorialRequest) {
        TutorialTable newItem = new TutorialTable(tutorialRequest.getEmail(), tutorialRequest.getAge(), tutorialRequest.getName());
        cassandraOperations.insert(newItem, InsertOptions.builder()
                .consistencyLevel(ConsistencyLevel.LOCAL_QUORUM).build());
        return newItem;
    }
}
