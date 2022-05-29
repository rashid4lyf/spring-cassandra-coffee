package com.rashiddy.springcassandrademo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TutorialTable {

    @PrimaryKey
    private String email;

    private int age;

    private String name;
}
