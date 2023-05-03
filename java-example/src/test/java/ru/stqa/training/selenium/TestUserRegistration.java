package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;


import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class TestUserRegistration extends TestBase{




  @Test
  public void registrationUser() {

    //Открытие браузера по заданному урлу
    driver.get("http://localhost:8081/litecart/en/");
    //Ждем, пока в title не появится "Online Store | My Store"
    wait.until(titleIs("Online Store | My Store"));

    //Открытие страницы регистрации
    driver.findElement(By.cssSelector("td > a")).click();

    //Заполняем обязательные поля на форме регистрации регистрации
    driver.findElement(By.name("firstname")).sendKeys("name1");
    driver.findElement(By.name("lastname")).sendKeys("lastname1");
    driver.findElement(By.name("address1")).sendKeys("name1");
    driver.findElement(By.name("postcode")).sendKeys("postcode1");
    driver.findElement(By.name("city")).sendKeys("city1");

    //Выбор пендосов из выпадашки
    driver.findElement(By.cssSelector("span [class=select2-selection__rendered]")).click();
    driver.findElement(By.cssSelector("input[class=select2-search__field]")).sendKeys("United States");
    driver.findElement(By.cssSelector(".select2-results li:nth-of-type(1)")).click();

    //Выбор зоны пендосов
    driver.findElement(By.cssSelector("select[name=\"zone_code\"][data-size=\"medium\"]")).click();
    driver.findElement(By.cssSelector("option[value=\"AK\"]")).click();

    //Ввод мыла(сделать уникальным?) и телефона
    driver.findElement(By.cssSelector("input[type=\"email\"][name=\"email\"]")).sendKeys("email1@mail.ru");
    driver.findElement(By.cssSelector("input[type=\"tel\"][name=\"phone\"]")).sendKeys("+7777777777");
    //Ввод пароля и подтверждение паролья
    driver.findElement(By.name("password")).sendKeys("password1");
    driver.findElement(By.name("confirmed_password")).sendKeys("password1");



    //НАжать на Create Account
    driver.findElement(By.name("create_account")).click();

    //LogOut
    driver.findElement(By.cssSelector("div#box-account a[href*=logout]")).click();

    //повторный вход в только что созданную учётную запись
    driver.get("http://localhost:8081/litecart/en/");
    wait.until(titleIs("Online Store | My Store"));
    driver.findElement(By.cssSelector("input[type=\"email\"][name=\"email\"]")).sendKeys("email1@mail.ru");
    driver.findElement(By.name("password")).sendKeys("password1");

    //LogOut
    driver.findElement(By.cssSelector("div#box-account a[href*=logout]")).click();


  }
}
