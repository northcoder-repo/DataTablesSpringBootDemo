package com.northcoder.demo;

import com.northcoder.demo.services.EmployeeService;
import com.northcoder.demo.services.ResponseContainer;
import com.northcoder.demo.services.request.ServerSideRequest;
import jakarta.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    private final EmployeeService service;

    @Inject
    public DemoController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping(path = "/listing")
    public String getListing() {
        return "demo"; // demo.html
    }

    @PostMapping(path = "/listing")
    @ResponseBody
    public ResponseContainer postListing(@RequestBody ServerSideRequest ssr) {
        // JSON response: https://datatables.net/manual/server-side#Returned-data
        return service.getListing(ssr);
    }

}
