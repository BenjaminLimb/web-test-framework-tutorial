package org.example.a;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author benjaminlimb
 */
public class BasicSeleniumTest {

  public static Logger LOG = LoggerFactory.getLogger(BasicSeleniumTest.class);

  @Test
  public void basicExample() {
    WebDriver driver = new FirefoxDriver();
    driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    LOG.info("GOTO: [http://google.com]");
    driver.navigate().to("http://google.com");

    LOG.info("ENTER TEXT in Search Box[Software Test Professionals Spring 2015]");
    WebElement searchBox = driver.findElement(By.cssSelector("[name='q']"));
    searchBox.sendKeys("Software Test Professionals Spring 2015");

    LOG.info("CLICK Button [Hourglass Icon]");
    WebElement goButton = driver.findElement(By.cssSelector("[name='btnG']"));
    goButton.click();

    ExpectedConditions.elementToBeClickable(By.cssSelector("#rso .srg .g:nth-of-type(1) .r a")); // This is needed if the element will load initially disabled or hidden.

    LOG.info("CLICK First Result");
    WebElement firstResult = driver.findElement(By.cssSelector("#rso .srg .g:nth-of-type(1) .r a"));
    firstResult.click();

    LOG.info("ASSERT URL is [http://www.stpcon.com/]");
    String currentURL = driver.getCurrentUrl();
    Assert.assertEquals(currentURL, "http://www.stpcon.com/");

    LOG.info("CLICK BROWSER BACK BUTTON");
    driver.navigate().back();

    LOG.info("ASSERT URL contains [https://www.google.com]");
    String currentURL2 = driver.getCurrentUrl();
    Assert.assertTrue(currentURL2.contains("https://www.google.com"));

    LOG.info("CLICK First Result");
    firstResult = driver.findElement(By.cssSelector("#rso .srg .g:nth-of-type(1) .r a"));
    firstResult.click();

    LOG.info("CLICK Button [pricing]");
    WebElement pricingButton = driver.findElement(By.cssSelector("#menu-item-832 a"));
    pricingButton.click();

    LOG.info("ASSERT URL equals [http://www.stpcon.com/pricing-spring2015/]");
    String currentURL3 = driver.getCurrentUrl();
    Assert.assertEquals(currentURL3, "http://www.stpcon.com/pricing-spring2015/");

    LOG.info("CLICK Button [Register Now]");
    WebElement registerNowButton = driver.findElement(By.cssSelector("[href='https://www.regonline.com/STPConS15']"));
    registerNowButton.click();

    LOG.info("ASSERT URL equals [https://www.regonline.com/Register/Checkin.aspx?EventID=1649374]");
    String currentURL4 = driver.getCurrentUrl();
    Assert.assertEquals(currentURL4, "https://www.regonline.com/Register/Checkin.aspx?EventID=1649374");

    driver.close();
  }
}
