package com.bemal.customer_management_system.repository;

import com.bemal.customer_management_system.Entity.FamilyMember;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {

    @Query("SELECT f FROM FamilyMember f WHERE f.customer.id = :customerId")
    public List<FamilyMember> getAllFamilyMembersByCustomerId(@Param("customerId") Long customerId);

    @Transactional
    @Modifying
    @Query("UPDATE FamilyMember f SET f.name = :name WHERE f.id = :familyMemberId")
    void updateFamilyMemberName(@Param("familyMemberId") Long familyMemberId, @Param("name") String name);

}

