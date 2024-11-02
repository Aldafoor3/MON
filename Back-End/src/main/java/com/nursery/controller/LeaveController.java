package com.nursery.controller;

import com.nursery.model.Leaves;
import com.nursery.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/leaves")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})
public class LeaveController {

    private final LeaveService leaveService;

    @Autowired
    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @GetMapping
    public List<Leaves> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public Optional<Leaves> getLeaveById(@PathVariable Long id) {
        return leaveService.getLeaveById(id);
    }

    @PostMapping("/saveLeave")
    public Leaves saveLeave(@RequestBody Leaves leaves) {
        return leaveService.saveLeave(leaves);
    }

    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable Long id) {
        leaveService.deleteLeave(id);
    }

    @PutMapping("/{id}")
    public Leaves updateLeave(@PathVariable Long id, @RequestBody Leaves leavesDetails) {
        return leaveService.updateLeave(id, leavesDetails);
    }
}
