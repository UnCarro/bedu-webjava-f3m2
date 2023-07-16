package com.test.interviewer.model;

import com.test.interviewer.Interviewer;

public class Interview {
    private int id;
    private Candidate candidate;
    private Interviewer interviewer;
    private InterviewType interviewType;
    private Technology technology;
    private Discipline discipline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }

    public InterviewType getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(InterviewType interviewType) {
        this.interviewType = interviewType;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
    public void add() {
        // add code in the next release

    }
    public void save(){
        // add code in the next release

    }
    public void delete(){
        // add code in the next release

    }

}
