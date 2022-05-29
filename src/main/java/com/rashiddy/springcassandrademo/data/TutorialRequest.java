package com.rashiddy.springcassandrademo.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TutorialRequest {

    private String email;
    private int age;
    private String name;
}
