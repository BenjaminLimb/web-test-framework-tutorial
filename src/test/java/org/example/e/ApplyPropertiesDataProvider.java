package org.example.e;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.syftkog.web.test.framework.Driver;
import org.syftkog.web.test.framework.PropertiesDataProvider;
import org.syftkog.web.test.framework.TestCaseContext;
import org.testng.annotations.Test;

/**
 *
 * @author benjaminlimb
 */
public class ApplyPropertiesDataProvider {

  public static Logger LOG = LoggerFactory.getLogger(ApplyPropertiesDataProvider.class);

  @Test(groups = {"acceptance"}, dataProvider = "getTestConfigurations", dataProviderClass = PropertiesDataProvider.class)
  public void googleSearchTest(TestCaseContext context) {
    Driver driver = context.getDriver();

    GoogleSearchPage googlePage = new GoogleSearchPage(context).load();

    googlePage.searchFor("Software Test Professionals Spring 2015");

    googlePage.firstResult.clickAndLoadPage(STPConferencePage.class);

    driver.navigateBack();

    googlePage.assertPage().loaded();

    // The driver.close() is not needed because it is handled by the DriverManagerListener
  }

  /**
   * Note that you can use the context directly because it implements the
   * HasDriver interface.
   *
   * @param context
   */
  @Test(groups = {"regression"}, dataProvider = "getTestConfigurations", dataProviderClass = PropertiesDataProvider.class)
  public void pricingTest(TestCaseContext context) {

    STPConferencePage stpPage = new STPConferencePage(context).load();

    STPPricingPage stpPricingPage = stpPage.clickPricingButtonAndLoadPricingPage();

    stpPricingPage.clickRegisterNowAndLoadRegistrationPage();

  }

}
