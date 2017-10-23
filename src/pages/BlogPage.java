package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.Utilities;

public class BlogPage extends Utilities{
	
	/*** Gets blog page h1 header which is '24 hours in Washington D.C.'
	 * **/
	public WebElement getBlogH1Title(){
		return driver.findElement(By.xpath(common.getProperty("BlogPage_H1Title_xpath")));
	}
	
	/*** Gets comment box locator before logging in to facebook
	 * **/
	public WebElement getCommentBox_beforeFBLogin(){
		return driver.findElement(By.xpath(common.getProperty("CommentTextbox_BeforeFBLogin_xpath")));
	}
	
	/*** Gets comment box locator after logging in to facebook
	 * **/
	public WebElement getCommentBox_afterFBLogin(){
		return driver.findElement(By.xpath(common.getProperty("commentBoxAfterFBLogin_xpath")));
	}
	
	
	/*** Gets Log In button to facebook
	 * **/
	public void getLogInButton(){
		 driver.findElement(By.xpath(common.getProperty("LogInToPost_xpath"))).click();
	}
	
	/*** Gets Post button which appears after FB LogIn
	 * **/
	public WebElement getPostButton(){
		return driver.findElement(By.xpath(common.getProperty("PostButton_xpath")));
	}

	/*** Function to post comment to blog '24 hours in Washington D.C.' with first name
	 * **/
	public void commentWithFirstName(){
		getBlogH1Title().isDisplayed();
		
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println(iframes.size());
		//driver.switchTo().frame("f3463eadc30861a");
		//driver.switchTo().frame("f1a3db0fa6b79e8");
		/*for(int i=0; i<iframes.size(); i++){
			driver.switchTo().frame(i);
			int total=driver.findElements(By.xpath("//textarea")).size();
			System.out.println(total);
		    driver.switchTo().defaultContent();
		    }*/
		driver.switchTo().frame(1);
		je.executeScript("arguments[0].scrollIntoView(true);", getCommentBox_beforeFBLogin());
		String comment = "[Pooja]-Testing blog comment for 24 Hours in Washington D.C.";
		getCommentBox_beforeFBLogin().sendKeys(comment);
		getLogInButton();
		
		//get Window handles to switch to FB login new window
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // This corresponds to new FB logn window
		
		//perform acctions on new window
		driver.findElement(By.id(common.getProperty("Email_ID"))).sendKeys(common.getProperty("emailID_value"));
		driver.findElement(By.id(common.getProperty("Password_ID"))).sendKeys(common.getProperty("password_value"));
		driver.findElement(By.id(common.getProperty("LogInButton_ID"))).click();
		driver.switchTo().window(tabs.get(0));
		driver.switchTo().frame(1);
		wait.until(ExpectedConditions.elementToBeClickable(getPostButton()));
		getPostButton().click();
		
		/****   View if comment is posted with correct parameters   ****/
		String userNameXpath = "//a[normalize-space()='Pooja Kumari']";
		String commentXpath = "//span/span/span[normalize-space()='"+comment+"']";
		driver.findElement(By.xpath(userNameXpath)).isDisplayed();
		driver.findElement(By.xpath(commentXpath)).isDisplayed();
	}
	
	/*** Function to post comment to blog '24 hours in Washington D.C.' with last name
	 * @throws InterruptedException 
	 * **/
	public void commentWithLastName() throws InterruptedException{
		String comment = "[Kumari]-Testing blog comment for 24 Hours in Washington D.C.";
		Actions actions = new Actions(driver);
		actions.moveToElement(getCommentBox_afterFBLogin());
		Thread.sleep(6000); // added alongwith Actions to avoid auto focus error for comment box
		actions.click();
		actions.sendKeys(comment);
		actions.build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(getPostButton()));
		getPostButton().click();
		
		/****   View if comment is posted with correct parameters   ****/
		String userNameXpath = "//a[normalize-space()='Pooja Kumari']";
		String commentXpath = "//span/span/span[normalize-space()='"+comment+"']";
		driver.findElement(By.xpath(userNameXpath)).isDisplayed();
		driver.findElement(By.xpath(commentXpath)).isDisplayed();
	}

}
