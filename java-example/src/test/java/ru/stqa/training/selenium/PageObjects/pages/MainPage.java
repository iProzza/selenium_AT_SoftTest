package ru.stqa.training.selenium.PageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MainPage extends Page{

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public MainPage open () {
    //Открытие браузера по заданному урлу
    driver.get("http://localhost:8081/litecart/en/");
    //Ждем, пока в title не появится "Online Store | My Store"
    wait.until(titleIs("Online Store | My Store"));
    return this;
  }

  public void selectFirstProduct(){
    //открыть первый товар из списка
    driver.findElements(By.cssSelector("div#box-campaigns li")).get(0).click();
    Select selectProduct = new Select(driver.findElement(By.name("options[Size]")));
    selectProduct.selectByValue("Small");

  }

  public void openShopCart() {
    //Открыть корзину
    driver.findElement(By.cssSelector(".link[href*='checkout']")).click();

  }

}
