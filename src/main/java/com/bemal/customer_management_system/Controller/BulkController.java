package com.bemal.customer_management_system.Controller;

import com.bemal.customer_management_system.Entity.Customer;
import com.bemal.customer_management_system.Services.CustomerBulkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class BulkController {

    private final CustomerBulkService service;

    public BulkController(CustomerBulkService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        try {
            List<Customer> customers = service.extractDataFromExcel(file.getInputStream());
            service.insertBulkData(customers);
            return ResponseEntity.ok().body("Data inserted successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during data insertion");
        }
    }
}

