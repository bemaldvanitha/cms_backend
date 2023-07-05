package com.bemal.customer_management_system.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "family_member")
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "name")
    private String name;

    public FamilyMember() {
    }

    public FamilyMember(Long id, Customer customer, String name) {
        this.id = id;
        this.customer = customer;
        this.name = name;
    }

    public FamilyMember(Customer customer, String name) {
        this.customer = customer;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "id=" + id +
                ", customer=" + customer +
                ", name='" + name + '\'' +
                '}';
    }
}

