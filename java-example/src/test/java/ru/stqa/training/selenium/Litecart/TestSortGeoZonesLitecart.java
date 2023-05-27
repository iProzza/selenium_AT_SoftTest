package ru.stqa.training.selenium.Litecart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestSortGeoZonesLitecart extends TestBase {

  @Test
  public void geozonesTest(){

    //Логинимся в админке
    driver.get("http://localhost:8081/litecart/admin/");
    driver.manage().window().maximize();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    wait.until(titleIs("My Store"));

    //Открываем категорию Geo Zones
    driver.findElement(By.xpath("//span[text()='Geo Zones']")).click();

    //В список geoZonesCount кладем кол-во элементов по класснейм "row"
    List<WebElement> countriesCountList = driver.findElements(By.className("row"));
    //Создаем пустой массив countriesArray
    ArrayList<String> countriesArray = new ArrayList<>();

    //С помощью цикла открываем каждый раздел(страну) из списка countriesCount по локатору //td/a[not(contains(@title,'Edit'))]
    for (int i = 0; i < countriesCountList.size(); i++){
      driver.findElements(By.xpath("//td/a[not(contains(@title,'Edit'))]")).get(i).click();

      //Создаем список зон по локатору //select[contains(@name, 'zone_code')]/option[@selected]
      List<WebElement> zonesList = driver.findElements(By.xpath("//select[contains(@name, 'zone_code')]/option[@selected]"));
      //Создаем пустой массив zonesArray
      ArrayList<String> zonesArray = new ArrayList<>();

      //Циклом заполняем массив zonesArray названиями зон
      for (WebElement zone : zonesList) {
        zonesArray.add(zone.getText());
      }
      //Создаем пустой массив zonesArraySorted
      ArrayList<String> zonesArraySorted = new ArrayList<>();
      //Заполняем массив zonesArraySorted
      zonesArraySorted.addAll(zonesArray);
      //Сортируем массив zonesArraySorted
      Collections.sort(zonesArraySorted);
      //Сравиниваем zonesArray и отсортированный zonesArraySorted
      Assert.assertTrue("Список геозон расположен не в алфавитном порядке", zonesArray.equals(zonesArraySorted));
    }
  }
}
