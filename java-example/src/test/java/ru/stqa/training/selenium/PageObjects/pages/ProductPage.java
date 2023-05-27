package ru.stqa.training.selenium.PageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class ProductPage extends Page{

  public ProductPage(WebDriver driver) {
    super(driver);
  }

  public void addProductToShopCart() throws InterruptedException {
    //Добавляем товар в корзину
    driver.findElement(By.cssSelector("button[name='add_cart_product']")).click();
    sleep(1000);

  }

  public void returnToMainPage() {
    //Открыть главную страницу
    driver.findElement(By.cssSelector(".fa.fa-home")).click();
    wait.until(titleIs("Online Store | My Store"));
  }
}
