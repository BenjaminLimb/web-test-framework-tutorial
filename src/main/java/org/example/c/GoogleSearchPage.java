package org.example.c;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

/**
 * @see https://code.google.com/p/selenium/wiki/PageFactory
 * @author benjaminlimb
 */
public class GoogleSearchPage {

  public static Logger LOG = LoggerFactory.getLogger(GoogleSearchPage.class);
  public static String url = "https://www.google.com";
  private WebDriver driver = null;

  // CONSTRUCTOR - this is required for PageFactory to initialize the page.
  public GoogleSearchPage(WebDriver driver) {
    this.driver = driver;
  }

  // ELEMENTS
  @FindBy(css = "[name='q']") // Note that although we could use the name=q using the css selector allows us to use firefinder to see the element on the page.
  private WebElement searchBox;

  @FindBy(css = "[name='btnG']")
  private WebElement goButton;

  @FindBy(css = "#rso .srg .g:nth-of-type(1) .r a")
  private WebElement firstResult;

  // PAGE FUNCTIONS
  public void load() {
    LOG.info("GOTO: [" + url + "]");
    driver.navigate().to(url);
  }

  public void assertCorrectURL() {
    LOG.info("ASSERT URL is [" + url + "]");
    String currentURL = driver.getCurrentUrl();
    Assert.assertTrue(currentURL.contains(url), "Current URL [" + currentURL + "] must contain url [" + url + "]");
  }

  public void searchFor(String text) {
    LOG.info("ENTER TEXT in Search Box[" + text + "]");
    searchBox.sendKeys(text);
  }

  public void clickSearch() {
    ExpectedConditions.elementToBeClickable(goButton); // This is needed if the element will load initially disabled or hidden.
    LOG.info("CLICK Button [Hourglass Icon]");
    goButton.click();
  }

  public void clickFirstResult() {
    LOG.info("CLICK First Result");
    ExpectedConditions.elementToBeClickable(firstResult); // This is needed if the element will load initially disabled or hidden.
    firstResult.click();
  }

}
