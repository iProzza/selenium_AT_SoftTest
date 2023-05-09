package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.training.selenium.TestBase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TestProductCart extends TestBase {

  @Test
  public void productCartTest() throws InterruptedException {

    //Открытие браузера по заданному урлу
    driver.get("http://localhost:8081/litecart/en/");
    //Ждем, пока в title не появится "Online Store | My Store"
    wait.until(titleIs("Online Store | My Store"));

    //открыть первый товар из списка
    driver.findElements(By.cssSelector("div#box-campaigns li")).get(0).click();
    Select selectProduct = new Select(driver.findElement(By.name("options[Size]")));
    selectProduct.selectByValue("Small");

    //Добавляем товар в корзину
    driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
    sleep(1000);

    //Проверка товаров в корзине
    Assert.assertEquals(driver.findElement(By.cssSelector("div#cart span.quantity")).getText(), "1");

    //Открытие браузера по заданному урлу
    driver.get("http://localhost:8081/litecart/en/");
    //Ждем, пока в title не появится "Online Store | My Store"
    wait.until(titleIs("Online Store | My Store"));
    sleep(500);

    //Выбор товара и добавление в корзину
    driver.findElement(By.cssSelector("div#box-most-popular a[href*=red-duck-p-3]")).click();
    sleep(500);
    driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
    sleep(1000);

    //Открытие браузера по заданному урлу
    driver.get("http://localhost:8081/litecart/en/");
    //Ждем, пока в title не появится "Online Store | My Store"
    wait.until(titleIs("Online Store | My Store"));
    sleep(500);

    //Выбор товара и добавление в корзину
    driver.findElement(By.cssSelector("div#box-latest-products a[href*=yellow-duck-p-1]")).click();
    Select selectProduct1 = new Select(driver.findElement(By.name("options[Size]")));
    selectProduct1.selectByValue("Small");
    driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
    sleep(1000);
    sleep(500);

    //Проверка что товаров в корзине 3
    Assert.assertEquals(driver.findElement(By.cssSelector("div#cart span.quantity")).getText(), "3");
    driver.findElement(By.cssSelector("div#cart a.link")).click();
    sleep(1000);

    //Удаление товаров из корзины
    WebElement tableElement = driver.findElement(By.cssSelector("div#order_confirmation-wrapper"));
    wait.until(visibilityOf(tableElement));
    while (driver.findElements(By.cssSelector("[name=remove_cart_item]")).size() != 0) {
      driver.findElement(By.cssSelector("[name=remove_cart_item]")).click();
    }
    sleep(500);
    wait.until(stalenessOf(tableElement));

  }
}