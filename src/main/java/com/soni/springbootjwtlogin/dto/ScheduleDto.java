package com.soni.springbootjwtlogin.dto;

import com.soni.springbootjwtlogin.model.ScheduleInfo;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {

    private LocalDate workDate;
    private Integer userId;
    private int shiftLengthHours;

    public ScheduleDto(ScheduleInfo scheduleInfo) {
        this.workDate = scheduleInfo.getWorkDate();
        this.userId = scheduleInfo.getUserId();
        this.shiftLengthHours = scheduleInfo.getShiftLengthHours();
    }
}
