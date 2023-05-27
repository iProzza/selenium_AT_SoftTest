package ru.stqa.training.selenium.PageObjects.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.PageObjects.pages.MainPage;
import ru.stqa.training.selenium.PageObjects.pages.ProductPage;
import ru.stqa.training.selenium.PageObjects.pages.ShopCartPage;

public class Application {

  private WebDriver driver;
  private WebDriverWait wait;

  private MainPage mainPage;
  private ProductPage productPage;
  private ShopCartPage shopcartPage;

  public Application() {
    driver = new ChromeDriver();
    mainPage = new MainPage(driver);
    productPage = new ProductPage(driver);
    shopcartPage = new ShopCartPage(driver);
    wait = new WebDriverWait(driver, 10);
  }


  public void goToMainPage() {
    mainPage.open();
  }


  public void addProductToShopCart() throws InterruptedException {
    mainPage.selectFirstProduct();
    productPage.addProductToShopCart();
    productPage.returnToMainPage();
  }

  public void goToShopCart(){
    mainPage.openShopCart();
  }

  public void removeProductFromCart() throws InterruptedException {
    shopcartPage.removeProductFromCart();
  }

  public void quit() {
    driver.quit();
  }
}


