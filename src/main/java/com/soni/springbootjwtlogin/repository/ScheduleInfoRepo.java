package com.soni.springbootjwtlogin.repository;

import com.soni.springbootjwtlogin.model.ScheduleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleInfoRepo extends JpaRepository<ScheduleInfo, Integer> {
    List<ScheduleInfo> findByUserId(Integer userId);
}
