package com.bemal.customer_management_system.repository;

import com.bemal.customer_management_system.Entity.Address;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("SELECT a FROM Address a WHERE a.customer.id = :customerId")
    public List<Address> getAllAddressesByCustomerId(@Param("customerId") Long customerId);

    @Transactional
    @Modifying
    @Query("UPDATE Address a SET a.addressLine1 = :addressLine1, a.addressLine2 = :addressLine2 WHERE a.id = :addressId")
    void updateAddressLines(@Param("addressId") Long addressId, @Param("addressLine1") String addressLine1, @Param("addressLine2") String addressLine2);
}
