package scripts;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import components.Components;
import utilities.Utilities;

public class VerifyPageTitleAndReportBrokenLinks {
	
	private static final Logger LOGGER = Logger.getLogger(VerifyPageTitleAndReportBrokenLinks.class.getName());
	Components compObj = new Components();
	
	@BeforeClass
	public void startBrowser(){
		Utilities.startBrowser();
	}
	
	@Test(priority=0)
	public void verifyLandingPageTitle(){
		try {
			compObj.verifyLandingPageTitle_Comp();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=1)
	public void verifyLandingPageH1HeaderIsSDETTest(){
		try {
			compObj.verifyLandingPageH1Header_Comp();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	public void verifyBrokenLinksOnLandingPage(){
		try{
			compObj.reportBrokenLinks_Comp();
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@AfterClass
	public void closeBrowser(){
		Utilities.closeBrowser();
	}

}
