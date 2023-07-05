package com.bemal.customer_management_system.Services;

import com.bemal.customer_management_system.Entity.Address;
import com.bemal.customer_management_system.Entity.FamilyMember;
import com.bemal.customer_management_system.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddressesAssociateToOneUser(Long customerId){
        return addressRepository.getAllAddressesByCustomerId(customerId);
    }

    public void updateAddressLines(Long addressId, String addressLine1, String addressLine2){
        addressRepository.updateAddressLines(addressId, addressLine1, addressLine2);
    }

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long addressId, Address updatedAddress) {
        updatedAddress.setId(addressId);
        return addressRepository.save(updatedAddress);
    }

    public Address getAddressById(Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found with id: " + addressId));
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}

