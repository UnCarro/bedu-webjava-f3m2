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
    //public ResponseEntity<?> createInterviewer(@RequestBody Interviewer dataToAdd) {
    public ResponseEntity<Interviewer> createInterviewer(@RequestBody Interviewer dataToAdd) {

        Interviewer interviewer = new Interviewer(dataToAdd.getName(),
                dataToAdd.getLastName(),
                dataToAdd.getEmail(),
                dataToAdd.getIsActive());

        //try {

            Interviewer result = interviewer.add();

            return ResponseEntity.created(URI.create("/add-interviewer")).body(result);
            


        //} catch (Exception e) {
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        // }
    }

}
