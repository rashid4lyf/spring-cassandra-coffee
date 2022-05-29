package com.rashiddy.springcassandrademo.models;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Data
public class Customer {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private UUID id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String email;

    private String name;

    private String totalOrders;

    public Customer(String email, String name, String totalOrders) {
        this.email = email;
        this.name = name;
        this.totalOrders = totalOrders;
        this.id = Uuids.timeBased();
    }
}
