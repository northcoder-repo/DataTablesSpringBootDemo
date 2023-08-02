package com.northcoder.demo;

import com.northcoder.demo.entities.Employee;
import com.northcoder.demo.services.ResponseContainer;
import com.northcoder.demo.services.request.Column;
import com.northcoder.demo.services.request.OrderCol;
import com.northcoder.demo.services.request.Search;
import com.northcoder.demo.services.request.ServerSideRequest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private DemoController demoController;

    //
    // @SpringBootTest loads the Spring app context, so we can do this:
    //
    @Test
    public void contextLoads() {
        assertThat(demoController).isNotNull();
    }

    //
    // INTEGRATION TEST:
    // This test assumes you have the test database set up and loaded.
    //
    @Test
    public void tableResults() {
        ServerSideRequest ssr = buildRequest();
        ResponseContainer response = demoController.postListing(ssr);
        assertThat(response.data()).size().isEqualTo(1);
        if (response.data().size() == 1) {
            Employee emp = response.data().get(0);
            assertThat(emp.name()).isEqualTo("Tiger Nixon");
        }
    }

    private ServerSideRequest buildRequest() {
        Search noSearch = new Search(null, false);

        Column nameCol = new Column("name", null, true, true, noSearch);
        Column positionCol = new Column("position", null, true, true, noSearch);
        Column officeCol = new Column("office", null, true, true, noSearch);
        Column ageCol = new Column("age", null, true, true, noSearch);
        Column startDateCol = new Column("startDate", null, true, true, noSearch);
        Column salaryCol = new Column("salary", null, true, true, noSearch);
        List<Column> columns = List.of(nameCol, positionCol, officeCol, ageCol, startDateCol, salaryCol);

        OrderCol orderCol = new OrderCol(3, "asc");
        List<OrderCol> order = List.of(orderCol);

        Search search = new Search("nixon", false);

        return new ServerSideRequest(1, columns, order, 0, 10, search);
    }

}
