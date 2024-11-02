package com.nursery.service;

import com.nursery.model.Attendance;
import com.nursery.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendances() {
        return (List<Attendance>) attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    public Attendance updateAttendance(Long id, Attendance attendanceDetails) {
        return attendanceRepository.findById(id)
                .map(attendance -> {
                    attendance.setDate(attendanceDetails.getDate());
                    attendance.setStatus(attendanceDetails.getStatus());
                    attendance.setChild(attendanceDetails.getChild());
                    return attendanceRepository.save(attendance);
                })
                .orElseThrow(() -> new RuntimeException("Attendance not found with id " + id));
    }
}
