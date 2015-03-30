package org.example.d;

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

  @Test(groups = "acceptance")
  public void googleSearchTest() {
    TestCaseContext context = new TestCaseContext();
    Driver driver = context.getDriver();

    GoogleSearchPage googlePage = new GoogleSearchPage(driver).load();

    googlePage.searchFor("Software Test Professionals Spring 2015");

    STPConferencePage stpPage = googlePage.firstResult.clickAndLoadPage(STPConferencePage.class);
    //stpPage.assertPage().loaded();// This truly isn't necessary because by it's already implied by the clickAndLoadPage().

    driver.navigateBack();

    googlePage.assertPage().loaded();

    driver.close();
  }

  /**
   * Note that you can use the context directly because it implements the
   * HasDriver interface.
   */
  @Test(groups = "regression")
  public void pricingTest() {
    TestCaseContext context = new TestCaseContext();

    STPConferencePage stpPage = new STPConferencePage(context).load();

    STPPricingPage stpPricingPage = stpPage.clickPricingButtonAndLoadPricingPage();

    stpPricingPage.clickRegisterNowAndLoadRegistrationPage();

    context.getDriver().close();
  }

}
