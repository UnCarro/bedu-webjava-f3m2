package com.test.interviewer;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.ArrayList;

import com.test.interviewer.exceptions.InvalidEmailException;
import com.test.interviewer.exceptions.InvalidLastNameException;
import com.test.interviewer.exceptions.InvalidNameException;

public class Interviewer implements Serializable {
    public static List<Interviewer> data;

    int id;
    String name;
    String lastName;
    String email;
    Boolean isActive;

    public Interviewer(
            String name,
            String lastName,
            String email,
            Boolean isActive
    ) {
        if (data==null)
            data = new ArrayList<>();

        this.id = data.size() + 1;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.isActive = isActive;
    }

    public Interviewer add() throws InvalidEmailException, InvalidNameException, InvalidLastNameException{
        if (this.name.equals("") || this.name.length() < 3)
            throw new InvalidNameException("Invalid name");

        if (this.lastName.equals("") || this.lastName.length() < 3)
            throw new InvalidLastNameException("Invalid last name");

        if (this.email.equals("") || this.email.length() < 6)
            throw new InvalidEmailException("Invalid email");

        data.add(this);
        return this;
    }

    public void save(
            String name,
            String lastName,
            String email,
            Boolean isActive
    ) {

        this.name = name;

        this.lastName = lastName;

        this.email = email;
 
        this.isActive = isActive;

        data.add(this);

    }

    public void delete() throws Exception{
        Interviewer interviewer = Interviewer.getByEmail(this.email);

        if (interviewer != null) {
            data.remove(this);
            Interviewer.saveDataToFile();
        }
        else
            throw new Exception("Interviewer not found");
    }

    public static Interviewer getByEmail(String email) {
        for (Interviewer interviewer: data) {
            if (interviewer.email.equals(email))
                return interviewer;
        }

        return null;
    }

    public static void saveDataToFile() {
        try (   FileOutputStream fileOutputStream = new FileOutputStream("./interviewers");
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)
            ) {

            outputStream.writeObject(Interviewer.data);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 
    }

    public static void loadDataFromFile() {
        try (   FileInputStream fileInputStream = new FileInputStream("./interviewers");
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        )   {
            // Suppressing the unchecked cast warning because is the only data and data file defined in the app
            @SuppressWarnings("unchecked") 
            ArrayList<Interviewer> fileData = (ArrayList<Interviewer>) inputStream.readObject();

            Interviewer.data.clear();
            Interviewer.data.addAll(fileData);

        } catch (Exception e) {
            if (!e.getMessage().contains("No such file or directory"))
                e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "\nID: " + this.id +
                "\nName: " + this.name +
                "\nLast Name: " + this.lastName +
                "\nEmail: " + this.email +
                "\nIs Active: " + this.isActive + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getIsActive() {
        return isActive;
    }
}
