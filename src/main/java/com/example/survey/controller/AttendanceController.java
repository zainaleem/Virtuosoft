package com.example.survey.controller;

import com.example.survey.model.Option;
import com.example.survey.model.Attendance;
import com.example.survey.repository.AttendanceRepo;
import com.example.survey.repository.AttendanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceRepo attendanceRepo;

    @GetMapping("/attendances")
    public List<Attendance> getAttendances() {
        return attendanceRepo.findAll();
    }

    @PostMapping("/attendances")
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance AttendanceDetails) {
        AttendanceDetails = attendanceRepo.save(AttendanceDetails);
        return new ResponseEntity<Attendance>(AttendanceDetails, HttpStatus.OK);
    }

    @PutMapping("/attendances/{id}")
    public ResponseEntity<Attendance> updateAttendance(@RequestBody Attendance AttendanceDetails) {
        Attendance updateAttendance = null;
        Optional<Attendance> AttendanceOptional = attendanceRepo.findById(AttendanceDetails.getId());

        if (AttendanceOptional.isPresent()) {
            updateAttendance = AttendanceOptional.get();
            updateAttendance.setAttendanceType(AttendanceDetails.getAttendanceType());
            updateAttendance.setImagePath(AttendanceDetails.getImagePath());
            updateAttendance.setLatitude(AttendanceDetails.getLatitude());
            updateAttendance.setLongitude(AttendanceDetails.getLongitude());
            updateAttendance.setUser(AttendanceDetails.getUser());

            attendanceRepo.save(updateAttendance);
        }
        return ResponseEntity.ok(updateAttendance);
    }
}
