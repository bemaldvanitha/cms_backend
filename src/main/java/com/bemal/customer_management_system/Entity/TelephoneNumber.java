package com.bemal.customer_management_system.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "telephone_number")
public class TelephoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "number")
    private String number;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public TelephoneNumber(Long id, String number, Customer customer) {
        this.id = id;
        this.number = number;
        this.customer = customer;
    }

    public TelephoneNumber(String number, Customer customer) {
        this.number = number;
        this.customer = customer;
    }

    public TelephoneNumber() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "TelephoneNumber{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", customer=" + customer +
                '}';
    }
}

