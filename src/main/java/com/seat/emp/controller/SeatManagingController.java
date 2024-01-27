package com.seat.emp.controller;

import com.seat.emp.common.Result;
import com.seat.emp.model.dto.EmpSeatDto;
import com.seat.emp.service.SeatManagingSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
public class SeatManagingController {
    @Autowired
    private SeatManagingSvc seatManagingSvc;
    
    @GetMapping("/offices")
    public Result getOffices(){
        return Result.success(seatManagingSvc.getOffices());
    }
    @GetMapping("/office/{officeId}/floors")
    public Result getFloorsByOffice(@PathVariable @NotNull Integer officeId){
        return Result.success(seatManagingSvc.getFloorsByOffice(officeId));
    }
    @GetMapping("/office/{officeId}/floor/{floorNo}")
    public Result getSeatsByFloor(@PathVariable @NotNull Integer officeId,
                                  @PathVariable @NotNull Integer floorNo){
        return Result.success(seatManagingSvc.getSeatsByFloor(officeId, floorNo));
    }
    @GetMapping("/depts")
    public Result getDepts(){
        return Result.success(seatManagingSvc.getDepts());
    }
    @GetMapping("/dept/{deptId}/emps")
    public Result getEmpsByDept(@PathVariable @NotNull Integer deptId){
        return Result.success(seatManagingSvc.getEmpsByDept(deptId));
    }
    @PostMapping("/emp/seat")
    public Result updateEmpSeat(@RequestBody @NotNull EmpSeatDto dto){
        seatManagingSvc.updateEmpSeat(dto.getFlagChange(), dto.getFloorSeatSeq(), dto.getEmpId());
        return Result.success();
    }
}
