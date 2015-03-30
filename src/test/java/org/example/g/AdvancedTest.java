package org.example.g;


import org.example.g.GoogleHomePage;
import org.syftkog.web.test.framework.Driver;
import org.syftkog.web.test.framework.PropertiesDataProvider;
import org.syftkog.web.test.framework.TestCaseContext;
import org.testng.annotations.Test;

/**
 * An empty test
 *
 */
public class AdvancedTest {

  @Test(groups = {"acceptance"}, dataProvider = "getTestConfigurations", dataProviderClass = PropertiesDataProvider.class)
  public void testExample(TestCaseContext context) {
    

    Driver driver = context.getDriver();

    GoogleHomePage googleSearchPage = new GoogleHomePage(context).load(); // Note that some method chaining is supported.
    googleSearchPage.searchBox.setText("stpcon");
    googleSearchPage.firstResultLink.click();    
    
    driver.navigateBack();

    googleSearchPage.images.click();
        
    // Test google image search
    
    // expand first image result
    
    
    // look for geneology somewhere on the expader
    
    
    
  }
}
