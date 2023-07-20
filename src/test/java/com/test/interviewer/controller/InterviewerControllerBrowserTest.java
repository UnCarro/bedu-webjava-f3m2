package com.test.interviewer.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Assertions;

public class InterviewerControllerBrowserTest {
    
    private static WebDriver driver;

    @BeforeAll
    public static void setup(){
        // Get the operating system name
        String os = System.getProperty("os.name").toLowerCase();

        // Set the default path for the ChromeDriver executable
        String driverPath = ".\\driver\\chromedriver.exe";

        // Needed to run tests in github actions
        // Update the path for macOS or Linux   
        if (os.contains("mac") || os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            driverPath = "chromedriver";
        }

        // Set the property for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Abra la ventana en su tamaño máximo
        options.addArguments("disable-inforbars"); // Quitar las infobars
        options.addArguments("--disable-extensions"); // Deshabilitar las extensiones
        options.addArguments("--disable-dev-shm-usage"); // Extender el límite de recursos
        options.addArguments("--no-sandbox"); // Deshabilitar seguridad del S.O

        // Needed to run tests in github actions
        // Update properties for macOS or Linux
        if (os.contains("mac") || os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            options.addArguments("--url-base=/wd/hub &");
        }

        driver = new ChromeDriver(options);
    }

    @AfterAll
    public static void quit(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    @DisplayName("Interviewer add success")
    public void interviewerAddSuccess(){
        driver.get("http://localhost:5173");
        driver.findElement(By.id("interviewerName")).sendKeys("capri");
        driver.findElement(By.id("interviewerLastName")).sendKeys("martinez");
        driver.findElement(By.id("interviewerEmail")).sendKeys("capri@crazydog.com");
        driver.findElement(By.tagName("button")).click();
        String result = driver.findElement(By.className("success")).getText();
        Assertions.assertEquals(result,"Success!");
    }

    @Test
    @DisplayName("Interviewer add Error")
    public void interviewerAddError(){

        driver.get("http://localhost:5173");
        driver.findElement(By.id("interviewerName")).sendKeys("");
        driver.findElement(By.id("interviewerLastName")).sendKeys("martinez");
        driver.findElement(By.id("interviewerEmail")).sendKeys("capri@crazydog.com");
        driver.findElement(By.tagName("button")).click();
        String result1 = driver.findElement(By.className("error")).getText();

        driver.get("http://localhost:5173");
        driver.findElement(By.id("interviewerName")).sendKeys("capri");
        driver.findElement(By.id("interviewerLastName")).sendKeys("");
        driver.findElement(By.id("interviewerEmail")).sendKeys("capri@crazydog.com");
        driver.findElement(By.tagName("button")).click();
        String result2 = driver.findElement(By.className("error")).getText();

        driver.get("http://localhost:5173");
        driver.findElement(By.id("interviewerName")).sendKeys("capri");
        driver.findElement(By.id("interviewerLastName")).sendKeys("martinez");
        driver.findElement(By.id("interviewerEmail")).sendKeys("c@");
        driver.findElement(By.tagName("button")).click();
        String result3 = driver.findElement(By.className("error")).getText();

        Assertions.assertTrue(result1.contains("Invalid name"));
        Assertions.assertTrue(result2.contains("Invalid last name"));
        Assertions.assertTrue(result3.contains("Invalid email"));
    
    }

}




