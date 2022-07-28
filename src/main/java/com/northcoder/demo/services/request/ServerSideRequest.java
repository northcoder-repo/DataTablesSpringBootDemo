package com.northcoder.demo.services.request;

import java.util.List;

// this models the sent parameters for a server-side DataTable,
// as defined here: https://datatables.net/manual/server-side
public record ServerSideRequest(
        long draw,
        List<Column> columns,
        List<OrderCol> order,
        long start,
        long length,
        Search search) {

}
