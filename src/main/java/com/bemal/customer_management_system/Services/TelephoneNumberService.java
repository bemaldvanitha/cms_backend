package com.bemal.customer_management_system.Services;

import com.bemal.customer_management_system.Entity.TelephoneNumber;
import com.bemal.customer_management_system.repository.TelephoneNumberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelephoneNumberService {
    private final TelephoneNumberRepository telephoneNumberRepository;

    public TelephoneNumberService(TelephoneNumberRepository telephoneNumberRepository) {
        this.telephoneNumberRepository = telephoneNumberRepository;
    }

    public List<TelephoneNumber> getAllTelephoneNumbersAssociateToOneUser(Long customerId){
        return telephoneNumberRepository.getAllTelephoneNumbersByCustomerId(customerId);
    }

    public TelephoneNumber createTelephoneNumber(TelephoneNumber telephoneNumber) {
        return telephoneNumberRepository.save(telephoneNumber);
    }

    public TelephoneNumber updateTelephoneNumber(Long telephoneNumberId, TelephoneNumber updatedTelephoneNumber) {
        updatedTelephoneNumber.setId(telephoneNumberId);
        return telephoneNumberRepository.save(updatedTelephoneNumber);
    }

    public void updateOnlyTelephoneNumber(Long telephoneNumberId, String updatedNumber) {
        telephoneNumberRepository.updateTelephoneNumberNumber(telephoneNumberId, updatedNumber);
    }


    public TelephoneNumber getTelephoneNumberById(Long telephoneNumberId) {
        return telephoneNumberRepository.findById(telephoneNumberId)
                .orElseThrow(() -> new EntityNotFoundException("Telephone number not found with id: " + telephoneNumberId));
    }

    public List<TelephoneNumber> getAllTelephoneNumbers() {
        return telephoneNumberRepository.findAll();
    }

    public void deleteTelephoneNumber(Long telephoneNumberId) {
        telephoneNumberRepository.deleteById(telephoneNumberId);
    }
}
