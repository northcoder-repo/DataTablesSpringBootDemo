# DataTablesSpringBootDemo

See [this overview](https://northcoder.com/post/spring-boot-demo-for-datatables-ser/) for more information.

Before anyone gets too excited, this is just me messing around. 

This solution:

 - always fetches [every record](https://github.com/northcoder-repo/DataTablesSpringBootDemo/blob/03cb2cfaa4549e949b1bf2ffccdc9cac12c6f354/src/main/java/com/northcoder/demo/services/EmployeeService.java#LL34C30-L34C55) from my test database table.
 - uses Java streams to perform [filtering](https://github.com/northcoder-repo/DataTablesSpringBootDemo/blob/03cb2cfaa4549e949b1bf2ffccdc9cac12c6f354/src/main/java/com/northcoder/demo/services/EmployeeService.java#L37) and [sorting & pagination](https://github.com/northcoder-repo/DataTablesSpringBootDemo/blob/03cb2cfaa4549e949b1bf2ffccdc9cac12c6f354/src/main/java/com/northcoder/demo/services/EmployeeService.java#L42).

It does, however, include basic logic to make the filtering tolerant of [diacritics](https://github.com/northcoder-repo/DataTablesSpringBootDemo/blob/03cb2cfaa4549e949b1bf2ffccdc9cac12c6f354/src/main/java/com/northcoder/demo/services/EmployeeService.java#L107) and uppercase/lowercase - so that a search for any of `Motörhead`, `motörhead`, `Motorhead`, or `motorhead` will find any of the other variants.

It does not handle:
 - column-specific searching
 - global searching with regexes

It _does_ handle [multi-column sorting](https://github.com/northcoder-repo/DataTablesSpringBootDemo/blob/03cb2cfaa4549e949b1bf2ffccdc9cac12c6f354/src/main/java/com/northcoder/demo/services/EmployeeService.java#L53).

If you want to use the DataTables [Search Builder](https://datatables.net/extensions/searchbuilder/), then be aware of how it creates its own additional query parameters - the same as you get by executing [`searchBuilder.getDetails()`](https://datatables.net/reference/api/searchBuilder.getDetails()).

---

If I were going to refactor this to reduce the burden of always using `demoRepository.findAll()`, I would build a dynamically constructed JDBC prepared statement, executed via Spring's `JdbcTemplate`. In my case, because my demo uses MySQL, I would consider using its `LIMIT` and `OFFSET` clauses. But I would be aware that other databases may have different syntax for these (or maybe even no syntax at all).

See also [Another Spring Boot Demo for DataTables Server-Side Processing](https://northcoder.com/post/another-spring-boot-demo-for-datata/), which is one such approach.
