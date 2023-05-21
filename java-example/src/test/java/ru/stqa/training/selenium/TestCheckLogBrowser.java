package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestCheckLogBrowser extends TestBase {

  @Test
  public void testCheckLogBrowser() throws InterruptedException {
    //Логинимся в админке
    driver.get("http://localhost:8081/litecart/admin/");
    driver.manage().window().maximize();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    wait.until(titleIs("My Store"));

    //Заходим в Catalog
    driver.findElement(By.xpath("//span[text()='Catalog']")).click();
    sleep(500);
    //Заходим в товары
    driver.findElement(By.xpath("//a[text()='Rubber Ducks']")).click();
    sleep(500);

    //Создаем список товаров
    List<WebElement> productList = driver.findElements(By.cssSelector("tr.row img + a"));

    //Циклом открываем каждый товар и проверяем в логе браузера ошибки
    for (int i = 0; i < productList.size(); i++) {
      List<WebElement> products = driver.findElements(By.cssSelector("tr.row img + a"));
      products.get(i).click();

      for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
        if (!l.getMessage().equals("")) {
            Assert.fail("После открытия товара появлятся ошибка браузера " + l.getMessage());
          }
        }
        driver.navigate().back();
      }

    }
  }
