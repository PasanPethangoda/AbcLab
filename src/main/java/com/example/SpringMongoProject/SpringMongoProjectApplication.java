package com.example.SpringMongoProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMongoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoProjectApplication.class, args);

		// Set the path to the ChromeDriver executable (download from
		https://sites.google.com/chromium.org/driver/ )
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		// Create a new instance of the ChromeDriver
		WebDriver driver = new ChromeDriver();
		// Navigate to a website
		driver.get("http://localhost:3000/");

		// Perform some actions (e.g., print the title)
		System.out.println("Page Title: " + driver.getTitle());
		// Close the browser
		driver.quit();





	}

}
