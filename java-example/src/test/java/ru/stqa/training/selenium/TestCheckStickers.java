package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestCheckStickers extends TestBase{

  @Test
  public void stickersTest(){
    driver.get("http://localhost:8081/litecart/en/");
    wait.until(titleIs("Online Store | My Store"));

    List<WebElement> productsCount = driver.findElements(By.className("product column shadow hover-light"));

    for (WebElement product : productsCount) {
      List<WebElement> stickers = product.findElements(By.xpath("//div[contains(@class,\"sticker\")]"));

      if(stickers.size() == 1){
        Assert.assertTrue("У каждого товара один стикер", true);
      }
    }


  }
}
