package com.test.interviewer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.interviewer.Interviewer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InterviewerController.class)
class InterviewerControllerTest {
    @SuppressWarnings("unused")
    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("unused")
    @MockBean
    private Interviewer mkInterviewer;
    @Test
    void createInterviewer() throws Exception {
        Interviewer.emptyData();
        Interviewer interviewerParameter = new Interviewer("capri", "martinez", "capri@crazydog.com", true);

        given(mkInterviewer.add()).willReturn(interviewerParameter);

        mockMvc.perform(post("/add-interviewer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(interviewerParameter)))
                .andExpect(status().isCreated())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("name", is(interviewerParameter.getName())))
                .andExpect(jsonPath("lastName", is(interviewerParameter.getLastName())))
                .andExpect(jsonPath("email", is(interviewerParameter.getEmail())))
                .andExpect(jsonPath("isActive", is(interviewerParameter.getIsActive())));

    }

    @Test
    void createInterviewerException() throws Exception {
        Interviewer.emptyData();
        Interviewer interviewerParameter = new Interviewer("", "martinez", "capri@crazydog.com", true);

        given(mkInterviewer.add()).willReturn(interviewerParameter);

        mockMvc.perform(post("/add-interviewer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(interviewerParameter)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string("Invalid name"));
    }

}