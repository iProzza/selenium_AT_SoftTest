package ru.stqa.training.selenium.PageObjects.tests;

import org.junit.Test;

public class TestShopCart extends TestBase{

  @Test
  public void productCartTest() throws InterruptedException {
    app.goToMainPage();
    app.addProductToShopCart();
    app.goToShopCart();
    app.removeProductFromCart();
    app.goToMainPage();
  }
}
