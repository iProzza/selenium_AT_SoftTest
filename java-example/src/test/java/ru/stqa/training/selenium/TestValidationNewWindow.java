package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestValidationNewWindow extends TestBase{


  @Test
  public void validationWindowTest() throws InterruptedException {

    //Логинимся в админке
    driver.get("http://localhost:8081/litecart/admin/");
    driver.manage().window().maximize();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    wait.until(titleIs("My Store"));
    sleep(500);

    //Открыть Countries
    driver.findElement(By.xpath("//span[text()='Countries']")).click();
    sleep(500);

    //Добавление новой страны(+ Add New Country)
    driver.findElement(By.cssSelector(".button[href*='doc=edit_country']")).click();
    sleep(500);

    //кликнуть по ссылке->новое окно->переключиться в новое окно->закрыть его->вернуться обратно->повторить эти действия для всех таких ссылок.
    List<WebElement> linkElementsList = driver.findElements(By.cssSelector("i.fa.fa-external-link"));

    for (WebElement linkElement: linkElementsList){
      String mainWindow = driver.getWindowHandle();
      Set<String> oldWindows = driver.getWindowHandles();
      linkElement.click();
      Set <String>  newWindows =  driver.getWindowHandles();
      newWindows.removeAll(oldWindows);
      String newWindow  = newWindows.iterator().next();
      driver.switchTo().window(newWindow);
      driver.close();
      driver.switchTo().window(mainWindow);
    }

  }
}
