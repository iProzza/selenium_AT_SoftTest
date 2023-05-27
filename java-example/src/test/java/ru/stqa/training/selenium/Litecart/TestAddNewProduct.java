package ru.stqa.training.selenium.Litecart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.TestBase;

import java.io.File;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestAddNewProduct extends TestBase {

  private File image = new File("src/test/resources/Super_Sapog.jpg");

  @Test
  public void addNewProduct() throws InterruptedException {



    //Логинимся в админке
    driver.get("http://localhost:8081/litecart/admin/");
    driver.manage().window().maximize();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    wait.until(titleIs("My Store"));

    //Зайти в Catalog
    driver.findElement(By.xpath("//span[text()='Catalog']")).click();
    sleep(500);

    //нажатие на кнопку "Add New Product"
    driver.findElement(By.cssSelector(".button[href*='doc=edit_product']")).click();

    //Переход в General
    driver.findElement(By.xpath("//a[text()='General']")).click();
    sleep(500);
    //Зполнение полей General + картинка
    driver.findElement(By.name("name[en]")).sendKeys("name1");
    driver.findElement(By.name("code")).sendKeys("66666");
    driver.findElement(By.name("new_images[]")).sendKeys(image.getAbsolutePath());


    //Переход в Information
    driver.findElement(By.xpath("//a[text()='Information']")).click();
    sleep(500);
    //Зполнение полей Information
    WebElement manufacturer = driver.findElement(By.name("manufacturer_id"));
    manufacturer.findElement(By.xpath("./option[not(@selected)]")).click();
    driver.findElement(By.name("keywords")).sendKeys("keywords");
    driver.findElement(By.name("short_description[en]")).sendKeys("shortDescription");
    driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys("description");
    driver.findElement(By.name("head_title[en]")).sendKeys("headTitle");
    driver.findElement(By.name("meta_description[en]")).sendKeys("metaDescription");

    //Переход В Prices
    driver.findElement(By.xpath("//a[text()='Prices']")).click();
    sleep(500);
    //Зполнение полей Prices
    driver.findElement(By.name("purchase_price")).sendKeys("100P");

    //Сохранение товара
    driver.findElement(By.name("save")).click();
    wait.until(titleIs("Catalog | My Store"));

    //убедиться, что товар появился в каталоге (в админке)
    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("name1"));
  }
}
