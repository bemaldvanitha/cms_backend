package com.bemal.customer_management_system.Services;

import com.bemal.customer_management_system.Entity.Customer;
import com.bemal.customer_management_system.repository.CustomerRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerBulkService {

    private final CustomerRepository customerRepository;

    public CustomerBulkService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void insertBulkData(List<Customer> customers) {
        customerRepository.saveAll(customers);
    }

    public List<Customer> extractDataFromExcel(InputStream inputStream) throws IOException {
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        List<Customer> customers = new ArrayList<>();

        for (Row row : sheet) {
            Customer customer = new Customer();
            customer.setName(row.getCell(0).getStringCellValue());
            customer.setDateOfBirth(row.getCell(1).getStringCellValue());
            customer.setNicNumber(row.getCell(2).getStringCellValue());

            customers.add(customer);
        }

        workbook.close();

        return customers;
    }
}