package org.example.e;

import org.syftkog.web.test.framework.HasDriver;
import org.syftkog.web.test.framework.Page;
import org.syftkog.web.test.framework.elements.Button;
import org.syftkog.web.test.framework.elements.Textbox;
import org.syftkog.web.test.framework.ElementListFactory;
import org.syftkog.web.test.framework.ElementList;
import org.syftkog.web.test.framework.elements.Link;

/**
 *
 * @author BenjaminLimb
 */
public class GoogleHomePage extends Page<GoogleHomePage> {

  private static final String url = "https://google.com";

  public Textbox searchBox = new Textbox(this, "Search Box", "[name='q']");
  public Button searchButton = new Button(this, "Google Search", "[name='btnK']");
  
  public Link images = new Link(this,"Images",".hdtb_msel");
  
  public Link firstImage = new Link(this,"First Image","#rg_s .rg_di:nth-of-type(1) a");
      
  public Link firstResultLink = new Link(this,"FirstResult","#rso .srg .g:nth-of-type(1) .r a");
          
  public ElementList<Link> resultLinks = ElementListFactory.create(Link.class, this, "Search Result Link", "#rso .srg .g .r a","#rso .srg .g:nth-of-type(###) .r a");
   
  public GoogleHomePage(HasDriver hasDriver) {
    super(hasDriver, url);
  }

}
