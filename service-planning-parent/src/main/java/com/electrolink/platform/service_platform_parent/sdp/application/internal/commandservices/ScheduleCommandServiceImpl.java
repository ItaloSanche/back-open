package com.electrolink.platform.service_platform_parent.sdp.application.internal.commandservices;

import com.electrolink.platform.service_platform_parent.sdp.domain.model.aggregates.ScheduleAggregate;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.CreateScheduleCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.UpdateScheduleCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.model.commands.DeleteScheduleCommand;
import com.electrolink.platform.service_platform_parent.sdp.domain.services.ScheduleCommandService;
import com.electrolink.platform.service_platform_parent.sdp.infrastructure.persistence.jpa.repositories.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ScheduleCommandServiceImpl implements ScheduleCommandService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleCommandServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    @Transactional
    public Long handle(CreateScheduleCommand command) {
        var schedule = new ScheduleAggregate(
                command.technicianId(),
                command.day(),
                command.startTime(),
                command.endTime()
        );
        return scheduleRepository.save(schedule).getId();
    }

    @Override
    @Transactional
    public void handle(UpdateScheduleCommand command) {
        var schedule = scheduleRepository.findById(command.scheduleId())
                .orElseThrow(() -> new IllegalArgumentException("Schedule not found"));
        schedule.updateFrom(command.day(), command.startTime(), command.endTime());
        scheduleRepository.save(schedule);
    }

    @Override
    @Transactional
    public void handle(DeleteScheduleCommand command) {
        if (!scheduleRepository.existsById(command.scheduleId())) {
            throw new IllegalArgumentException("Schedule not found");
        }
        scheduleRepository.deleteById(command.scheduleId());
    }
}
