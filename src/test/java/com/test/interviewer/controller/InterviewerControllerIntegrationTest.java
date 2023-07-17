package com.test.interviewer.controller;

import com.test.interviewer.Interviewer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InterviewerControllerIntegrationTest {
    private final TestRestTemplate restTemplate;

    @Autowired
    public InterviewerControllerIntegrationTest(TestRestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @Test
    void createInterviewer(){
        // Arrange
        Interviewer.emptyData();
        Interviewer interviewerParameter = new Interviewer("capri", "martinez", "capri@crazydog.com", true);
        Interviewer interviewerParameter2 = new Interviewer("grecia", "martinez", "grecia@crazydog.com", true);
        // Act
        ResponseEntity<Interviewer> response = restTemplate.postForEntity("/add-interviewer", interviewerParameter, Interviewer.class);
        ResponseEntity<Interviewer> response2 = restTemplate.postForEntity("/add-interviewer", interviewerParameter2, Interviewer.class);
        // Assert
        assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(response.getBody().getId(), equalTo(1));
        assertThat(response.getBody().getName(), equalTo(interviewerParameter.getName()));
        assertThat(response2.getStatusCode(), equalTo(HttpStatus.CREATED));
        assertThat(response2.getBody().getId(), equalTo(2));
        assertThat(response2.getBody().getName(), equalTo(interviewerParameter2.getName()));
    }

}
