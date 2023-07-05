package com.bemal.customer_management_system.Services;

import com.bemal.customer_management_system.Entity.FamilyMember;
import com.bemal.customer_management_system.Entity.TelephoneNumber;
import com.bemal.customer_management_system.repository.FamilyMemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyMemberService {
    private final FamilyMemberRepository familyMemberRepository;

    public FamilyMemberService(FamilyMemberRepository familyMemberRepository) {
        this.familyMemberRepository = familyMemberRepository;
    }

    public List<FamilyMember> getAllFamilyMembersAssociateToOneUser(Long customerId){
        return familyMemberRepository.getAllFamilyMembersByCustomerId(customerId);
    }

    public FamilyMember createFamilyMember(FamilyMember familyMember) {
        return familyMemberRepository.save(familyMember);
    }

    public FamilyMember updateFamilyMember(Long familyMemberId, FamilyMember updatedFamilyMember) {
        updatedFamilyMember.setId(familyMemberId);
        return familyMemberRepository.save(updatedFamilyMember);
    }

    public void updateFamilyMemberName(Long familyMemberId, String updatedName) {
        familyMemberRepository.updateFamilyMemberName(familyMemberId, updatedName);
    }

    public FamilyMember getFamilyMemberById(Long familyMemberId) {
        return familyMemberRepository.findById(familyMemberId)
                .orElseThrow(() -> new EntityNotFoundException("Family member not found with id: " + familyMemberId));
    }

    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberRepository.findAll();
    }

    public void deleteFamilyMember(Long familyMemberId) {
        familyMemberRepository.deleteById(familyMemberId);
    }
}

