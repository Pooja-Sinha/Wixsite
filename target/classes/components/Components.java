package components;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Assert;

import pages.BlogPage;
import pages.LandingPage;

public class Components{
	
	private static final Logger LOGGER = Logger.getLogger(Components.class.getName());
	LandingPage landingPageObj = new LandingPage();
	BlogPage blogPageObj = new BlogPage();
	
		public void verifyLandingPageTitle_Comp() throws Exception{
			try{
				System.out.println("Page title "+landingPageObj.getPageTitle());
				Assert.assertEquals(landingPageObj.getPageTitle(), "website");
			}catch(Exception e){
				LOGGER.log(Level.SEVERE, e.getMessage());
				throw e;
			}
		}
		
		public void verifyLandingPageH1Header_Comp() throws Exception{
			try{
				System.out.println("Page H1 Header is "+landingPageObj.getSDETTestH1().getText());
				Assert.assertEquals(landingPageObj.getSDETTestH1().getText(), "SDET Test");
			}catch(Exception e){
				LOGGER.log(Level.SEVERE, e.getMessage());
				throw e;
			}
		}
		
		public void reportBrokenLinks_Comp() throws Exception{
			try{
				landingPageObj.reportBrokenLinks();
			}catch(Exception e){
				LOGGER.log(Level.SEVERE, e.getMessage());
				throw e;
			}
		}
		
		public void commentOnBlogWithFirstName_Comp() throws Exception{
			try{
				landingPageObj.click24HoursH2();
				blogPageObj.commentWithFirstName();
				
			}catch(Exception e){
				LOGGER.log(Level.SEVERE, e.getMessage());
				throw e;
			}
		}

}
