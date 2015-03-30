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
public class GoogleSearchTest {

  public static Logger LOG = LoggerFactory.getLogger(GoogleSearchTest.class);

  @Test(groups = "acceptance")
  public void googleSearchTest() {
    TestCaseContext context = new TestCaseContext();
    Driver driver = context.getDriver();

    GoogleSearchPage googlePage = new GoogleSearchPage(driver).load();

    googlePage.searchFor("Software Test Professionals Spring 2015");

    googlePage.firstResult.clickAndLoadPage(STPConferencePage.class);

    driver.navigateBack();

    googlePage.assertPage().loaded();

    driver.close();
  }

}
