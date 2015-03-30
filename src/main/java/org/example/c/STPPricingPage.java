package org.example.c;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 *
 * @author benjaminlimb
 */
public class STPPricingPage {

  public static Logger LOG = LoggerFactory.getLogger(STPPricingPage.class);
  public static String url = "http://www.stpcon.com/pricing-spring2015/";
  private WebDriver driver = null;

  // CONSTRUCTOR - this is required for PageFactory to initialize the page.
  public STPPricingPage(WebDriver driver) {
    this.driver = driver;
  }

  // ELEMENTS
  @FindBy(css = "[href='https://www.regonline.com/STPConS15']")
  private WebElement registerNowButton;

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

  public RegOnlinePage clickRegisterNow() {
    LOG.info("CLICK Button [Register Now]");
    registerNowButton.click();
    return PageFactory.initElements(driver, RegOnlinePage.class);
  }

}
