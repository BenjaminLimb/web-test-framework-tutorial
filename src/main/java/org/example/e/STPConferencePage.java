package org.example.e;

import org.syftkog.web.test.framework.HasDriver;
import org.syftkog.web.test.framework.Page;
import org.syftkog.web.test.framework.elements.Button;

/**
 *
 * @author benjaminlimb
 */
public class STPConferencePage extends Page<STPConferencePage> {

  // CONSTRUCTOR - this is required for PageFactory to initialize the page.
  public STPConferencePage(HasDriver hasDriver) {
    super(hasDriver, "http://www.stpcon.com/");
  }

  // ELEMENTS
  public Button pricing = new Button(this, "Pricing", "#menu-item-832 a");

  // PAGE FUNCTIONS
  public STPPricingPage clickPricingButtonAndLoadPricingPage() {
    return pricing.clickAndLoadPage(STPPricingPage.class);
  }

}
