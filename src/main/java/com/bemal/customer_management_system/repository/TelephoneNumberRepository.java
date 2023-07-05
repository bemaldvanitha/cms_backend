package com.bemal.customer_management_system.repository;

import com.bemal.customer_management_system.Entity.TelephoneNumber;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelephoneNumberRepository extends JpaRepository<TelephoneNumber, Long> {

    @Query("SELECT tn FROM TelephoneNumber tn WHERE tn.customer.id = :customerId")
    List<TelephoneNumber> getAllTelephoneNumbersByCustomerId(@Param("customerId") Long customerId);

    @Transactional
    @Modifying
    @Query("UPDATE TelephoneNumber t SET t.number = :number WHERE t.id = :telephoneNumberId")
    void updateTelephoneNumberNumber(@Param("telephoneNumberId") Long telephoneNumberId, @Param("number") String number);

}

