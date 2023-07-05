package com.bemal.customer_management_system.Entity;

import jakarta.persistence.*;

import java.util.List;

@MappedSuperclass
public class User {

    private Long id;

    private String name;

    private String dateOfBirth;

    private String nicNumber;

    private List<TelephoneNumber> telephoneNumbers;

    private List<FamilyMember> familyMembers;

    private List<Address> addresses;

    public User(Long id, String name, String dateOfBirth, String nicNumber, List<TelephoneNumber> telephoneNumbers, List<FamilyMember> familyMembers, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nicNumber = nicNumber;
        this.telephoneNumbers = telephoneNumbers;
        this.familyMembers = familyMembers;
        this.addresses = addresses;
    }

    public User(String name, String dateOfBirth, String nicNumber, List<TelephoneNumber> telephoneNumbers, List<FamilyMember> familyMembers, List<Address> addresses) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nicNumber = nicNumber;
        this.telephoneNumbers = telephoneNumbers;
        this.familyMembers = familyMembers;
        this.addresses = addresses;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public List<TelephoneNumber> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(List<TelephoneNumber> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", nicNumber='" + nicNumber + '\'' +
                ", telephoneNumbers=" + telephoneNumbers +
                ", familyMembers=" + familyMembers +
                ", addresses=" + addresses +
                '}';
    }
}
