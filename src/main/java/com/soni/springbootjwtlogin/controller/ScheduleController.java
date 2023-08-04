package com.soni.springbootjwtlogin.controller;

import com.soni.springbootjwtlogin.dto.ScheduleDto;
import com.soni.springbootjwtlogin.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    @GetMapping("/test")
    public String getWelcome(){
        return "Welcome Guest";
    }

    @GetMapping("/view-all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_STAFF')")
    public List<ScheduleDto> getAllSchedule(){
        return scheduleService.getAllSchedule();
    }

    @GetMapping("/view-schedule")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_STAFF')")
    public List<ScheduleDto> getAllScheduleByUserId(@RequestParam Integer userId){
        return scheduleService.getAllScheduleByUserId(userId);
    }

    @PostMapping("/create-schedule")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Integer createSchedule(@RequestBody ScheduleDto scheduleDto){
        return scheduleService.createSchedule(scheduleDto);
    }

    @DeleteMapping("/delete-schedule")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteSchedule(@RequestParam Integer scheduleId){
        return scheduleService.deleteSchedule(scheduleId);
    }
}