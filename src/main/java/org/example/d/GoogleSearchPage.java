package org.example.d;

import org.syftkog.web.test.framework.HasDriver;
import org.syftkog.web.test.framework.Page;
import org.syftkog.web.test.framework.elements.Button;
import org.syftkog.web.test.framework.elements.Link;
import org.syftkog.web.test.framework.elements.Textbox;

/**
 * @see https://code.google.com/p/selenium/wiki/PageFactory
 * @author benjaminlimb
 */
public class GoogleSearchPage extends Page<GoogleSearchPage> {

  // CONSTRUCTOR
  public GoogleSearchPage(HasDriver hasDriver) {
    super(hasDriver, "https://www.google.com");
  }

  // ELEMENTS
  public Textbox searchBox = new Textbox(this, "Search Box", "[name='q']"); // Always use CSS
  public Button goButton = new Button(this, "Go Button(Hourglass Icon)", "[name='btnG']");
  public Link firstResult = new Link(this, "First Result", "#rso .srg .g:nth-of-type(1) .r a");

  // PAGE FUNCTIONS
  public void searchFor(String text) {
    searchBox.setText(text);
    goButton.click();
  }

  

}
