package org.example.e;

import org.syftkog.web.test.framework.HasDriver;
import org.syftkog.web.test.framework.Page;
import org.syftkog.web.test.framework.elements.Button;

/**
 *
 * @author benjaminlimb
 */
public class STPConfHomePage extends Page<STPConfHomePage> {

  public static String url = "http://www.stpcon.com/";

  public Button pricing = new Button(this, "Pricing", "#menu-item-832");

  public STPConfHomePage(HasDriver hasDriver, String url) {
    super(hasDriver, url);
  }

}
