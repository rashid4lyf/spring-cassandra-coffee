package com.rashiddy.springcassandrademo.data;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class IndividualCoffeeOrder {

    private UUID id;
    private String name;
    private String quantity;
}
