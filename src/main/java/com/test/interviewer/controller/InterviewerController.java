package com.test.interviewer.controller;

import com.test.interviewer.Interviewer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;

@RestController
@RequestMapping("/")
public class InterviewerController {
    @PostMapping("add-interviewer")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Interviewer> createInterviewer(@RequestBody Interviewer dataToAdd) {

        Interviewer interviewer = new Interviewer(dataToAdd.getName(),
                dataToAdd.getLastName(),
                dataToAdd.getEmail(),
                dataToAdd.getIsActive());

            Interviewer result = interviewer.add();

            return ResponseEntity.created(URI.create("/add-interviewer")).body(result);
    }
}
