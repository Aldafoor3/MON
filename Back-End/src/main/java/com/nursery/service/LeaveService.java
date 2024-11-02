package com.nursery.service;

import com.nursery.model.Leaves;
import com.nursery.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {
    private final LeaveRepository leaveRepository;

    @Autowired
    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public List<Leaves> getAllLeaves() {
        return (List<Leaves>) leaveRepository.findAll();
    }

    public Optional<Leaves> getLeaveById(Long id) {
        return leaveRepository.findById(id);
    }

    public Leaves saveLeave(Leaves leaves) {
        return leaveRepository.save(leaves);
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }

    public Leaves updateLeave(Long id, Leaves leavesDetails) {
        return leaveRepository.findById(id)
                .map(leaves -> {
                    leaves.setStartDate(leavesDetails.getStartDate());
                    leaves.setEndDate(leavesDetails.getEndDate());
                    leaves.setReason(leavesDetails.getReason());
                    leaves.setEmployee(leavesDetails.getEmployee());
                    return leaveRepository.save(leaves);
                })
                .orElseThrow(() -> new RuntimeException("Leave not found with id " + id));
    }
}
