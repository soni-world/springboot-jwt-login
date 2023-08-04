package com.soni.springbootjwtlogin.service;


import com.soni.springbootjwtlogin.dto.ScheduleDto;

import java.util.List;

public interface ScheduleService {

    List<ScheduleDto> getAllSchedule();
    List<ScheduleDto> getAllScheduleByUserId(Integer userId);
    Integer createSchedule(ScheduleDto scheduleDto);
    String deleteSchedule(Integer scheduleId);
}
