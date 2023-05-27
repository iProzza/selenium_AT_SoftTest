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

public class TestSortCountriesLitecart extends TestBase {

  @Test
  public void countriesTest(){

    //Логинимся в админке
    driver.get("http://localhost:8081/litecart/admin/");
    driver.manage().window().maximize();
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("login")).click();
    wait.until(titleIs("My Store"));

    //Открываем категорию Countries
    driver.findElement(By.xpath("//span[text()='Countries']")).click();

    //В список countriesCount кладем кол-во элементов по класснейм "row"
    List<WebElement> countriesCount = driver.findElements(By.className("row"));
    //Создаем пустой массив actualCountriesList
    ArrayList<String> countriesArray = new ArrayList<>();

    //Пробегаемся по списку стран и заполняем массив countriesArray названиями стран
    for (int i = 0; i < countriesCount.size(); i++) {
      WebElement countryRow = driver.findElements(By.cssSelector(".row")).get(i);
      WebElement country = countryRow.findElement(By.xpath("./td[5]/a"));
      countriesArray.add(country.getText());

      //Если кол-во зон по локатору //td[6] != 0 то
      if (!countryRow.findElement(By.xpath("./td[6]")).getText().equals("0")) {
        //Кликаем по этому элементу
        country.click();
        //Создаем список zonesList по локатору //input[contains(@name, 'name')][@type='hidden']
        List<WebElement> zonesList = driver.findElements(By.xpath("//input[contains(@name, 'name')][@type='hidden']"));
        //Создаем пустой массив zoneArray
        ArrayList<String> zoneArray = new ArrayList<>();

        //В цикле проходя по списку зон, добавляем в массив zoneArray, названия зон
        for (WebElement zone : zonesList) {
          zoneArray.add(zone.getAttribute("value"));
        }
        //Создаем массив zoneArraySorted, заполняем его значениями из zoneArray
        ArrayList<String> zoneArraySorted = new ArrayList<>();
        zoneArraySorted.addAll(zoneArray);
        //Сортируем массив zoneArraySorted
        Collections.sort(zoneArraySorted);
        //Сравиниваем отсортированный массив зон zoneArraySorted и оригинал countriesArray
        Assert.assertTrue("Список геозон расположен не в алфавитном порядке", zoneArray.equals(zoneArraySorted));
        driver.navigate().back();
      }
    }

    //Создаем пустой массив countriesArraySorted и заполняем его значениями из массива countriesArray
    ArrayList<String> countriesArraySorted = new ArrayList<>();
    countriesArraySorted.addAll(countriesArray);
    //Сортируем массив countriesArraySorted
    Collections.sort(countriesArraySorted);
    //Сравиниваем отсортированный массив стран countriesArraySorted и оригинал countriesArray
    Assert.assertTrue("Список стран расположен не в алфавитном порядке", countriesArray.equals(countriesArraySorted));
  }

}

