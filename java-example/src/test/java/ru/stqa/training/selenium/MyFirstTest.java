package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 3);
  }

  @Test
  public void myFirstTest() {
    driver.get("http://www.google.com");
    driver.manage().window().maximize();
    driver.findElement(By.name("q")).sendKeys("webdriver");
//    driver.findElement(By.name("btnK")).click();
    driver.findElement(By.xpath("//div[@class=\"FPdoLc lJ9FBc\"]//center/input[@name=\"btnK\"]")).click();
//    wait.until(titleIs("webdriver - Поиск в Google"));

  }

  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}