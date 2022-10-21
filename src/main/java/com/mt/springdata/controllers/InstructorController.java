package com.mt.springdata.controllers;

import com.mt.springdata.dtos.InstructorDetailDto;
import com.mt.springdata.services.IInstructorDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instructor")
@RequiredArgsConstructor
public class InstructorController {

    private final IInstructorDetails instructorDetails;

    @PostMapping("/addDetail")
    public void addInstructorDetails(@RequestBody InstructorDetailDto instructorDetailDto) {
        instructorDetails.addInstructorDetails(instructorDetailDto);
    }

}
