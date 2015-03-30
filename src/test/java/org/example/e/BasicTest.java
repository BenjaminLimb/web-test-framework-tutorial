package org.example.e;

import org.example.e.GoogleHomePage;
import org.syftkog.web.test.framework.Driver;
import org.syftkog.web.test.framework.TestCaseContext;
import org.testng.annotations.Test;

/**
 * An empty test
 *
 */
public class BasicTest {

  @Test
  public void testExample() {
    TestCaseContext context = new TestCaseContext();
    Driver driver = context.getDriver();

    GoogleHomePage googleSearchPage = new GoogleHomePage(driver);
    googleSearchPage.load(); // Note that some method chaining is supported.
    
    
  }
}
