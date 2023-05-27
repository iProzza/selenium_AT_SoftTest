package ru.stqa.training.selenium.Litecart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.stqa.training.selenium.TestBase;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestProductsLitecart extends TestBase {

  @Test
  public void verifyProductPriceTest() {

    //Открытие браузера по заданному урлу
    driver.get("http://localhost:8081/litecart/en/");
    //Ждем, пока в title не появится "Online Store | My Store"
    wait.until(titleIs("Online Store | My Store"));


    //Складываем  в переменные текст названия товара,зачеркнутая и красная цена
    String regularNameMainPage =  driver.findElements(By.cssSelector("div#box-campaigns li")).
            get(0).findElement(By.cssSelector("div.name")).getText();

    String regularPriceMainPage =  driver.findElements(By.cssSelector("div#box-campaigns li")).
            get(0).findElement(By.cssSelector("s.regular-price")).getText();

    String regularCampaignPriceMainPage =  driver.findElements(By.cssSelector("div#box-campaigns li")).
            get(0).findElement(By.cssSelector("strong.campaign-price")).getText();

    //Выбираем первый товар в блоке Campaigns
    driver.findElements(By.cssSelector("div#box-campaigns li")).get(0).click();

    //Сравниваем название товара с главной и на странице товара
    Assert.assertEquals(driver.findElement(By.cssSelector("h1")).getText(), regularNameMainPage);
    //Сравниваем зачеркнутую цену с главной и на странице товара
    Assert.assertEquals(driver.findElement(By.cssSelector("s.regular-price")).getText(), regularPriceMainPage);
    //Сравниваем красную цену с главной и на странице товара
    Assert.assertEquals(driver.findElement(By.cssSelector(".campaign-price")).getText(), regularCampaignPriceMainPage);
  }
}
