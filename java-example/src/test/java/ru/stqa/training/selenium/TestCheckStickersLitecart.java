package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestCheckStickersLitecart extends TestBase{

  @Test
  public void stickersTest(){
    //Открытие браузера по заданному урлу
    driver.get("http://localhost:8081/litecart/en/");
    //Ждем, пока в title не появится "Online Store | My Store"
    wait.until(titleIs("Online Store | My Store"));

    //Создаем список вебэлементов productsCount по имени класса
    List<WebElement> productsCount = driver.findElements(By.className("product column shadow hover-light"));

    //Проходимся циклом по списку
    for (WebElement product : productsCount) {
      //Кладем в перем. stickers элементы по локатору //div[contains(@class,"sticker")]
      List<WebElement> stickers = product.findElements(By.xpath("//div[contains(@class,\"sticker\")]"));


      if(stickers.size() == 1){
        //Если кол-во стикеров по локатору != 1, то показываем это сообщение
        Assert.assertTrue("У каждого товара не один стикер", false);
      }
    }


  }
}
