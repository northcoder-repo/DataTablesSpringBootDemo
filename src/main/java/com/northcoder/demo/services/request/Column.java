package com.northcoder.demo.services.request;

public record Column(
        String data,
        String name,
        boolean searchable,
        boolean orderable,
        Search search) {

}
