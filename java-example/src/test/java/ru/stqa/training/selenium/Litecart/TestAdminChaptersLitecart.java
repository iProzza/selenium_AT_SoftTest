package ru.stqa.training.selenium.Litecart;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.TestBase;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestAdminChaptersLitecart extends TestBase {

  @Test
  public void litecartTest() {
    //Открытие браузера по заданному урлу
    driver.get("http://localhost:8081/litecart/admin/");
    //Придаем браузеру макс. размер
    driver.manage().window().maximize();
    //Находим эелемент по имени username и сразу вводим значение admin в него
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    //Находим эелемент по имени login и сразу кликаем на него
    driver.findElement(By.name("login")).click();
    //Ждем, пока в title не появится My Store
    wait.until(titleIs("My Store"));

    //Кладем в перем. sectionsCount число, равное кол-ву эл-ов по id "app-"
    int sectionsCount = driver.findElements(By.id("app-")).size();

    //Пробегаемся по каждому эл-ту "app-"
    for (int i = 1; i <= sectionsCount; i++) {
      WebElement section = driver.findElement(By.xpath(String.format("//li[@id='app-'][%s]/a", i)));
      //В sectionName кладем текст из локатора //li[@id='app-']
      String sectionName = section.getText();
      //Клик по секции
      section.click();
      //Кладем в перем. subSectionsCount число, равное кол-ву эл-ов по локатору //ul[@class='docs']/li
      int subSectionsCount = driver.findElements(By.xpath("//ul[@class='docs']/li")).size();

      //Если подсекций(subSectionsCount) > 0 то пробегаемся по ним циклом
      if (subSectionsCount > 0) {
        for (int j = 1; j <= subSectionsCount; j++) {
          WebElement subSection = driver.findElement(By.xpath(String.format("//ul[@class='docs']/li[%s]/a", j)));
          //В subSectionName кладем текст из локатора //ul[@class='docs']/li/a
          String subSectionName = subSection.getText();
          //Клик по подсекции
          subSection.click();
          if (sectionName.equals("Settings")) {
            //Проверка что в теге h1 содержится название Settings(т.к. в этом разделе у всех подсекций один заголовок Settings)
            Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Settings"));
          } else if (subSectionName.equals("Background Jobs")) {
            //Проверка что в теге h1 содержится название Job Modules(т.к. у этой подсекции такой заголовок)
            Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Job Modules"));
          } else {
            //Проверка что в теге h1 содержится название подсекции (subSectionName)
            Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains(subSectionName));
          }
        }
      } else {
        //Проверка что в теге h1 содержится название секции (sectionName)
        Assert.assertTrue(driver.findElement(By.tagName("h1")).getText().contains(sectionName));
      }
    }
  }
}