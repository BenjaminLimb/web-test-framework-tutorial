package org.example.b;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 *
 * @author benjaminlimb
 */
public class STPConferencePage {

  public static Logger LOG = LoggerFactory.getLogger(STPConferencePage.class);
  public static String url = "http://www.stpcon.com/";
  private WebDriver driver = null;

  // CONSTRUCTOR - this is required for PageFactory to initialize the page.
  public STPConferencePage(WebDriver driver) {
    this.driver = driver;
  }
  
  // ELEMENTS
  @FindBy(css = "#menu-item-832 a")
  private WebElement pricingButton;
  
  // PAGE FUNCTIONS
  public void assertCorrectURL() {
    LOG.info("ASSERT URL is [" + url + "]");
    String currentURL = driver.getCurrentUrl();
    Assert.assertEquals(currentURL, url);
  }
  
  public void clickPricingButton(){
    LOG.info("CLICK Button [pricing]");    
    pricingButton.click();
  }
  
  
}
