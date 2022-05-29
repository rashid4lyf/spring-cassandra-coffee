package com.rashiddy.springcassandrademo.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CoffeeRequest {

    private String name;
    private String description;
    private String imageUrl;
}
