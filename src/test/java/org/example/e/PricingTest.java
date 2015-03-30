package org.example.e;

import org.syftkog.web.test.framework.PropertiesDataProvider;
import org.syftkog.web.test.framework.TestCaseContext;
import org.testng.annotations.Test;

/**
 *
 * @author benjaminlimb
 */
public class PricingTest {

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
