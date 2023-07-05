package com.bemal.customer_management_system.Controller;

import com.bemal.customer_management_system.Custom.MessageResponse;
import com.bemal.customer_management_system.Entity.*;
import com.bemal.customer_management_system.Services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final CityService cityService;

    private final CountryService countryService;

    private final AddressService addressService;
    private final TelephoneNumberService telephoneNumberService;

    private final FamilyMemberService familyMemberService;

    public CustomerController(CustomerService customerService, CityService cityService, CountryService countryService, AddressService addressService, TelephoneNumberService telephoneNumberService, FamilyMemberService familyMemberService) {
        this.customerService = customerService;
        this.cityService = cityService;
        this.countryService = countryService;
        this.addressService = addressService;
        this.telephoneNumberService = telephoneNumberService;
        this.familyMemberService = familyMemberService;
    }

    // correct
    @PostMapping
    public ResponseEntity<User> createCustomer(@RequestBody User user) {
        Customer customer = new Customer(user.getName(), user.getDateOfBirth(), user.getNicNumber());
        Customer createdCustomer = customerService.createCustomer(customer);
        for(Address address: user.getAddresses()){
            City city = new City(address.getCity().getName());
            Country country = new Country(address.getCountry().getName());
            cityService.createCity(city);
            countryService.createCountry(country);
            Address address1 = new Address(customer, address.getAddressLine1(), address.getAddressLine2(), city, country);
            addressService.createAddress(address1);
        }
        for(TelephoneNumber telephoneNumber: user.getTelephoneNumbers()){
            TelephoneNumber telephoneNumber1 = new TelephoneNumber(telephoneNumber.getNumber(), customer);
            telephoneNumberService.createTelephoneNumber(telephoneNumber1);
        }
        for(FamilyMember familyMember: user.getFamilyMembers()){
            FamilyMember familyMember1 = new FamilyMember(customer, familyMember.getName());
            familyMemberService.createFamilyMember(familyMember1);
        }
        return ResponseEntity.ok(user);
    }

    // correct -- only update address lane 1 and 2, family member name, telephone number
    @PatchMapping("/{customerId}")
    public ResponseEntity<User> updateCustomer(@PathVariable Long customerId, @RequestBody User updatedCustomer) {
        Customer updated = new Customer(updatedCustomer.getName(), updatedCustomer.getDateOfBirth(), updatedCustomer.getNicNumber());
        updated = customerService.updateCustomer(customerId, updated);

        for(Address address : updatedCustomer.getAddresses()){
            addressService.updateAddressLines(address.getId(), address.getAddressLine1(), address.getAddressLine2());
        }

        for(TelephoneNumber telephoneNumber: updatedCustomer.getTelephoneNumbers()){
            telephoneNumberService.updateOnlyTelephoneNumber(telephoneNumber.getId(), telephoneNumber.getNumber());
        }

        for(FamilyMember familyMember: updatedCustomer.getFamilyMembers()){
            familyMemberService.updateFamilyMemberName(familyMember.getId(), familyMember.getName());
        }

        return ResponseEntity.ok(updatedCustomer);
    }

    //correct
    @GetMapping("/{customerId}")
    public ResponseEntity<User> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        List<TelephoneNumber> telephoneNumbers = telephoneNumberService.getAllTelephoneNumbersAssociateToOneUser(customerId);
        List<FamilyMember> familyMembers = familyMemberService.getAllFamilyMembersAssociateToOneUser(customerId);
        List<Address> addresses = addressService.getAllAddressesAssociateToOneUser(customerId);
        User user = new User(customerId, customer.getName(), customer.getDateOfBirth(), customer.getNicNumber(), telephoneNumbers, familyMembers, addresses);
        return ResponseEntity.ok(user);
    }

    // correct
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }
}

