package com.seat.emp.controller;

import com.seat.emp.common.Result;
import com.seat.emp.service.OfficeSeatSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class OfficeSeatController {

    @Autowired
    private OfficeSeatSvc officeSeatSvc;

    @GetMapping("/offices")
    public Result getOffices(){
        return Result.success(officeSeatSvc.getOffices());
    }
    @GetMapping("/office/{officeId}/floors")
    public Result getFloorsByOffice(@PathVariable @NotNull Integer officeId){
        return Result.success(officeSeatSvc.getFloorsByOffice(officeId));
    }
    @GetMapping("/office/{officeId}/floor/{floorNo}")
    public Result getSeatsByFloor(@PathVariable @NotNull Integer officeId,
                                  @PathVariable @NotNull Integer floorNo){
        return Result.success(officeSeatSvc.getSeatsByFloor(officeId, floorNo));
    }
    @GetMapping("/depts")
    public Result getDepts(){
        return Result.success(officeSeatSvc.getDepts());
    }
    @GetMapping("/dept/{deptId}/emps")
    public Result getEmpsByDept(@PathVariable @NotNull Integer deptId){
        return Result.success(officeSeatSvc.getEmpsByDept(deptId));
    }
}
