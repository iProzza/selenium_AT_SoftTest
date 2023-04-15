package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;


public class MyFirstTest extends TestBase{

  @Test
  public void myFirstTest() {
    driver.get("http://www.google.com");
    driver.manage().window().maximize();
    driver.findElement(By.name("q")).sendKeys("webdriver");
//    driver.findElement(By.name("btnK")).click();
    driver.findElement(By.xpath("//div[@class=\"FPdoLc lJ9FBc\"]//center/input[@name=\"btnK\"]")).click();
//    wait.until(titleIs("webdriver - Поиск в Google"));

  }

  @Test
  public void mySecondTest() {
    driver.get("http://www.google.com");
    driver.manage().window().maximize();
    driver.findElement(By.name("q")).sendKeys("webdriver");
//    driver.findElement(By.name("btnK")).click();
    driver.findElement(By.xpath("//div[@class=\"FPdoLc lJ9FBc\"]//center/input[@name=\"btnK\"]")).click();
//    wait.until(titleIs("webdriver - Поиск в Google"));

  }

  @Test
  public void myThirdTest() {
    driver.get("http://www.google.com");
    driver.manage().window().maximize();
    driver.findElement(By.name("q")).sendKeys("webdriver");
//    driver.findElement(By.name("btnK")).click();
    driver.findElement(By.xpath("//div[@class=\"FPdoLc lJ9FBc\"]//center/input[@name=\"btnK\"]")).click();
//    wait.until(titleIs("webdriver - Поиск в Google"));

  }


}