package com.northcoder.demo.services;

import com.northcoder.demo.entities.Employee;
import java.util.List;

public record ResponseContainer(
        long draw,
        long recordsTotal,
        long recordsFiltered,
        List<Employee> data) {

}
