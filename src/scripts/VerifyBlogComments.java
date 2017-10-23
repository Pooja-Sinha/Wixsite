package scripts;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import components.Components;
import junit.framework.Assert;
import utilities.Utilities;

public class VerifyBlogComments {
	
	private static final Logger LOGGER = Logger.getLogger(VerifyPageTitleAndReportBrokenLinks.class.getName());
	Components compObj = new Components();
	
	@BeforeClass
	public void startBrowser(){
		Utilities.startBrowser();
	}
	
	@Test(priority=0)
	public void verifyBlogCommentWithFirstName(){
		try {
			compObj.commentOnBlogWithFirstName_Comp();
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
