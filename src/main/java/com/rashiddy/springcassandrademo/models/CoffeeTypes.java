package com.rashiddy.springcassandrademo.models;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@NoArgsConstructor
@Data
public class CoffeeTypes {

    @PrimaryKey
    private UUID id;

    private String name;

    private String description;

    private String imageUrl;


    public CoffeeTypes(String name, String description, String imageUrl) {
        this.id = Uuids.timeBased();
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
