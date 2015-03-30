package org.example.e;

import org.syftkog.web.test.framework.Driver;
import org.syftkog.web.test.framework.PropertiesDataProvider;
import org.syftkog.web.test.framework.TestCaseContext;
import org.testng.annotations.Test;

/**
 *
 * @author benjaminlimb
 */
public class GoogleSearchTest {

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

}
