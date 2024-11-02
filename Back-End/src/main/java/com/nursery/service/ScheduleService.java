package com.nursery.service;

import com.nursery.model.Schedule;
import com.nursery.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getAllSchedules() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    public Schedule updateSchedule(Long id, Schedule scheduleDetails) {
        return scheduleRepository.findById(id)
                .map(schedule -> {
                    schedule.setDate(scheduleDetails.getDate());
                    schedule.setDescription(scheduleDetails.getDescription());
                    schedule.setActivities(scheduleDetails.getActivities());
                    schedule.setChildren(scheduleDetails.getChildren());
                    return scheduleRepository.save(schedule);
                })
                .orElseThrow(() -> new RuntimeException("Schedule not found with id " + id));
    }
}
