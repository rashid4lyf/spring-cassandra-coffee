package com.rashiddy.springcassandrademo.models;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
@Data
public class CoffeeOrders {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private UUID id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String email;
    private String paymentStatus;
    private String orderItems;

    private String orderStatus;

    public CoffeeOrders(String email, String paymentStatus, String orderItems, String orderStatus) {
        this.email = email;
        this.paymentStatus = paymentStatus;
        this.orderItems = orderItems;
        this.id = Uuids.timeBased();
        this.orderStatus = orderStatus;
    }

}
