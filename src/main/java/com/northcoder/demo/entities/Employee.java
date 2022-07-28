package com.northcoder.demo.entities;

import java.time.LocalDate;

public record Employee(
        String name,
        String position,
        String office,
        int age,
        LocalDate startDate,
        String salary) {

}
