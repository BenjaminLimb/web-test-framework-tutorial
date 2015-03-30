package org.example.e;

import org.syftkog.web.test.framework.HasDriver;
import org.syftkog.web.test.framework.Page;
import org.syftkog.web.test.framework.elements.Link;

/**
 *
 * @author benjaminlimb
 */
public class STPPricingPage extends Page<STPPricingPage> {

  // CONSTRUCTOR - this is required for PageFactory to initialize the page.
  public STPPricingPage(HasDriver driver) {
    super(driver, "http://www.stpcon.com/pricing-spring2015/");
  }

  // ELEMENTS
  public Link registerNowButton = new Link(this, "Register Now", "[href='https://www.regonline.com/STPConS15']");

  // PAGE FUNCTIONS
  public RegOnlinePage clickRegisterNowAndLoadRegistrationPage() {
    LOG.info("CLICK Button [Register Now] and load registration page");
    return registerNowButton.clickAndLoadPage(RegOnlinePage.class);
  }

}
