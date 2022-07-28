package com.northcoder.demo.services;

import com.northcoder.demo.entities.Employee;
import com.northcoder.demo.services.request.ServerSideRequest;
import jakarta.inject.Inject;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Service;
import com.northcoder.demo.repositories.DemoRepository;
import com.northcoder.demo.services.request.Column;
import com.northcoder.demo.services.request.OrderCol;
import java.util.ArrayList;
import org.apache.commons.collections4.ComparatorUtils;

@Service
public class EmployeeService {

    private final DemoRepository demoRepository;

    @Inject
    public EmployeeService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public ResponseContainer getListing(ServerSideRequest ssr) {
        //
        // Just for demo purposes.
        //
        long grandTotal = demoRepository.count();
        List<Employee> all = demoRepository.findAll();

        // interim results to get total rows after filtering:
        List<Employee> filtered = all.stream()
                .filter(containsText(ssr.search().value().toLowerCase()))
                .toList();

        // one page of results:
        List<Employee> data = filtered.stream()
                .sorted(buildSorter(ssr))
                .skip(ssr.start())
                .limit(ssr.length())
                .toList();

        return new ResponseContainer(ssr.draw(), grandTotal, filtered.size(), data);
    }

    private Comparator<Employee> buildSorter(ServerSideRequest ssr) {
        // for multi-column sorting:
        List<Comparator<Employee>> sortChain = new ArrayList<>();
        for (OrderCol oc : ssr.order()) {
            sortChain.add(buildComparatorClause(oc, ssr.columns()));
        }
        // combines list of comparators into one comparator:
        return ComparatorUtils.chainedComparator(sortChain);
    }

    private Comparator<Employee> buildComparatorClause(OrderCol oc, List<Column> columns) {
        // default sort:
        Comparator<Employee> comp = Comparator.comparing(Employee::name);
        // which field to sort on - get column data name from column index:
        String colName = columns.get(oc.column()).data();
        switch (colName) {
            case "name" ->
                comp = Comparator.comparing(Employee::name);
            case "position" ->
                comp = Comparator.comparing(Employee::position);
            case "office" ->
                comp = Comparator.comparing(Employee::office);
            case "age" ->
                comp = Comparator.comparing(Employee::age);
            case "startDate" ->
                comp = Comparator.comparing(Employee::startDate);
            case "salary" ->
                comp = Comparator.comparing(Employee::salary);
        }
        // ascending or descending:
        return oc.dir().equals("asc") ? comp : comp.reversed();
    }

    private Predicate<Employee> containsText(String searchTerm) {
        // search all fields for case-insensitive search term:
        return e -> e.name().toLowerCase().contains(searchTerm)
                || e.position().toLowerCase().contains(searchTerm)
                || e.office().toLowerCase().contains(searchTerm)
                || String.valueOf(e.age()).toLowerCase().contains(searchTerm)
                || e.startDate().toString().toLowerCase().contains(searchTerm)
                || e.salary().toLowerCase().contains(searchTerm);
    }

}
