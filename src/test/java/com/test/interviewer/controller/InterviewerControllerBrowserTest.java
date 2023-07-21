package com.test.interviewer.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    void interviewerAddSuccess(){
        driver.get("http://localhost:5173");
        driver.findElement(By.id("interviewerName")).sendKeys("capri");
        driver.findElement(By.id("interviewerLastName")).sendKeys("martinez");
        driver.findElement(By.id("interviewerEmail")).sendKeys("capri@crazydog.com");
        driver.findElement(By.tagName("button")).click();
               // Use WebDriverWait to wait for the element to be present
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("success")));

        String result = driver.findElement(By.className("success")).getText();
        Assertions.assertEquals("Success!", result);
    }

    @Test
    @DisplayName("Interviewer add Error")
    void interviewerAddError(){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("http://localhost:5173");
        driver.findElement(By.id("interviewerName")).sendKeys("");
        driver.findElement(By.id("interviewerLastName")).sendKeys("martinez");
        driver.findElement(By.id("interviewerEmail")).sendKeys("capri@crazydog.com");
        driver.findElement(By.tagName("button")).click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error")));
        String result1 = driver.findElement(By.className("error")).getText();

        driver.get("http://localhost:5173");
        driver.findElement(By.id("interviewerName")).sendKeys("capri");
        driver.findElement(By.id("interviewerLastName")).sendKeys("");
        driver.findElement(By.id("interviewerEmail")).sendKeys("capri@crazydog.com");
        driver.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error")));
        String result2 = driver.findElement(By.className("error")).getText();

        driver.get("http://localhost:5173");
        driver.findElement(By.id("interviewerName")).sendKeys("capri");
        driver.findElement(By.id("interviewerLastName")).sendKeys("martinez");
        driver.findElement(By.id("interviewerEmail")).sendKeys("c@");
        driver.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error")));
        String result3 = driver.findElement(By.className("error")).getText();

        Assertions.assertTrue(result1.contains("Invalid name"));
        Assertions.assertTrue(result2.contains("Invalid last name"));
        Assertions.assertTrue(result3.contains("Invalid email"));
    
    }

}




