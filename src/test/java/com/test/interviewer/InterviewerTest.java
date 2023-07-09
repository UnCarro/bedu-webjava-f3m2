package com.test.interviewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.test.interviewer.exceptions.InvalidEmailException;
import com.test.interviewer.exceptions.InvalidNameException;
import com.test.interviewer.exceptions.InvalidLastNameException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;


public class InterviewerTest {
    static String existingInterviewerName = "Capri";
    static String existingInterviewerLastName = "Cho";
    static String existingInterviewerEmail =  "capri.cho@dogmail.com";

    @BeforeEach
    public void setUp() {
        Interviewer.data = new ArrayList<>();

        // We insert a user for testing delete and save
        Interviewer.data.add(new Interviewer(
                existingInterviewerName,
                existingInterviewerLastName,
                existingInterviewerEmail,
                true
        ));
    }

    @Test
    public void add() {
        
        Interviewer interviewer = new Interviewer(
                "Grecia",
                "Sanchez",
                "gregre@dogmail.com",
                true
        );

        try {
            interviewer.add();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        

        int expectedId = Interviewer.data.size();
        assertEquals(
                expectedId,
                interviewer.id,
                "Interviewer ID should be the new List's size"
        );
    }

    @Test
    public void add_NotValidDataExceptions() {
        // not valid email 
        Interviewer interviewer = new Interviewer(
                "Grecia",
                "Sanchez",
                "g@d.c",
                true
        );
        
        assertThrows(InvalidEmailException.class, () -> {interviewer.add();});

        // not valid name
        Interviewer interviewer2 = new Interviewer(
                "Gr",
                "Sanchez",
                "gregre@crazydog.com",
                true
        );
    
        assertThrows(InvalidNameException.class, () -> {interviewer2.add();});

        // not valid last name
        Interviewer interviewer3 = new Interviewer(
                "Grecia",
                "Sa",
                "gregre@crazydog.com",
                true
        );
    
        assertThrows(InvalidLastNameException.class, () -> {interviewer3.add();});

    }


    @Test
    public void getByEmail() {
        Interviewer result = Interviewer.getByEmail(existingInterviewerEmail);

        assertNotNull(result, "Interviewer should be found");
        assertEquals(
                existingInterviewerName,
                result.name,
                "Unexpected Interviewer Name"
        );
        assertEquals(
                existingInterviewerLastName,
                result.lastName,
                "Unexpected Interviewer Last Name"
        );
    }

    @Test
    public void getByNonExistingEmail() {
        String nonExistingEmail = "somebody@email.com";

        Interviewer result = Interviewer.getByEmail(nonExistingEmail);

        assertNull(result, "Interviewer should not be found");
    }

    @Test
    public void delete() {
        Interviewer existingInterviewer = Interviewer.data.get(0);

        int expectedSize = Interviewer.data.size() - 1;

        try {
            existingInterviewer.delete();
        } catch (Exception e) {
            fail("Unexpected Exception received: " + e.getMessage());
        }

        int actualSize = Interviewer.data.size();

        assertEquals(
                expectedSize,
                actualSize,
                "List should be smaller"
        );
    }
}