package com.northcoder.demo.entities;

import java.time.LocalDate;

public record Employee(
        String name,
        String position,
        String office,
        int age,
        LocalDate startDate,
        String salary)
        implements Comparable<Employee> {

    @Override
    public int compareTo(Employee other) {
        if (other == null || other.name == null) {
            return 1;
        }
        // just a crude demo of sorting on last name before 1st name,
        // which assumes there always is a last name and a 1st name!
        String[] thisNames = this.name.split(" ");
        String[] otherNames = other.name.split(" ");
        int i = thisNames[1].compareTo(otherNames[1]);
        if (i != 0) {
            return i;
        } else {
            return thisNames[0].compareTo(otherNames[0]);
        }
    }

}
