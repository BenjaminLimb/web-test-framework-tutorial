package org.example.b;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 *
 * @author benjaminlimb
 */
public class RegOnlinePage {

  public static Logger LOG = LoggerFactory.getLogger(RegOnlinePage.class);
  public static String url = "https://www.regonline.com/Register/Checkin.aspx?EventID=1649374";
  private WebDriver driver = null;

  // CONSTRUCTOR - this is required for PageFactory to initialize the page.
  public RegOnlinePage(WebDriver driver) {
    this.driver = driver;
  }

  // ELEMENTS
  
  
  // PAGE FUNCTIONS
  public void load() {
    LOG.info("GOTO: [" + url + "]");
    driver.navigate().to(url);
  }

  public void assertCorrectURL() {
    LOG.info("ASSERT URL is [" + url + "]");
    String currentURL = driver.getCurrentUrl();
    Assert.assertEquals(currentURL, url);
  }

}
