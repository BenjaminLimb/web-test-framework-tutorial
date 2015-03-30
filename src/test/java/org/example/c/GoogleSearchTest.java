package org.example.c;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 *
 * @author benjaminlimb
 */
public class GoogleSearchTest {

  public static Logger LOG = LoggerFactory.getLogger(GoogleSearchTest.class);

  @Test(groups = "acceptance")
  public void googleSearchTest() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    GoogleSearchPage googlePage = PageFactory.initElements(driver, GoogleSearchPage.class);
    googlePage.load();

    googlePage.searchFor("Software Test Professionals Spring 2015");
    googlePage.clickSearch();

    googlePage.clickFirstResult();

    STPConferencePage stpPage = PageFactory.initElements(driver, STPConferencePage.class);
    stpPage.assertCorrectURL();

    LOG.info("CLICK BROWSER BACK BUTTON");
    driver.navigate().back();

    googlePage.assertCorrectURL();

    driver.close();
  }

}
