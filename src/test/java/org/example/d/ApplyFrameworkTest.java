package org.example.d;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.syftkog.web.test.framework.Driver;
import org.syftkog.web.test.framework.TestCaseContext;
import org.testng.annotations.Test;

/**
 *
 * @author benjaminlimb
 */
public class ApplyFrameworkTest {

  public static Logger LOG = LoggerFactory.getLogger(ApplyFrameworkTest.class);

  @Test
  public void googleSearchTest() {
    TestCaseContext context = new TestCaseContext();
    Driver driver = context.getDriver();

    GoogleSearchPage googlePage = new GoogleSearchPage(driver).load();

    googlePage.searchFor("Software Test Professionals Spring 2015");

    STPConferencePage stpPage = googlePage.firstResult.clickAndLoadPage(STPConferencePage.class);
    stpPage.assertPage().loaded();

    LOG.info("CLICK BROWSER BACK BUTTON");
    driver.navigate().back();

    googlePage.assertPage().loaded();

    driver.close();
  }

  @Test
  public void pricingTest() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    STPConferencePage stpPage = PageFactory.initElements(driver, STPConferencePage.class);
    stpPage.load();

    STPPricingPage stpPricingPage = stpPage.clickPricingButton();
    stpPricingPage.assertPage().loaded();

    RegOnlinePage regOnlinePage = stpPricingPage.clickRegisterNow();
    regOnlinePage.assertPage().loaded();

    driver.close();
  }

}
