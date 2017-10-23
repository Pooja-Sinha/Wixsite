package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.Utilities;

public class LandingPage extends Utilities{
	
	private static final Logger LOGGER = Logger.getLogger(LandingPage.class.getName());
	private int brokenLinksCount;
	
	/*** Gets page title <title> on landing page
	 * **/
	public String getPageTitle(){
		return driver.getTitle();
	}
	
	/*** Gets page H1 Header which is 'SDET Test' on landing page
	 * **/
	public WebElement getSDETTestH1(){
		return driver.findElement(By.xpath(common.getProperty("SDETTest_H1_xpath")));
	}
	
	/*** Gets blog header which is '24 hours in Washington D.C.' on landing page
	 * **/
	public WebElement get24HoursH2(){
		return driver.findElement(By.xpath(common.getProperty("H2Title_xpath")));
	}
	
	/*** Clicks blog header which is '24 hours in Washington D.C.' on landing page
	 * **/
	public void click24HoursH2(){
		wait.until(ExpectedConditions.elementToBeClickable(get24HoursH2()));
		je.executeScript("arguments[0].scrollIntoView(true);", get24HoursH2());
		get24HoursH2().click();
	}
	
	/*** reportBrokenLinks() function reports number of broken links on landing page
	 * **/
	public void reportBrokenLinks(){
		brokenLinksCount = 0;
		List<WebElement> elementList = new ArrayList<>();
		elementList = driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total no.# of links on landing page<anchor tags & images> "+elementList.size());
		for(WebElement we:elementList){
			if(we!=null){
				String url = we.getAttribute("href");
				if(url!=null){
					verifyURLStatus(url);
				}else{
					brokenLinksCount++;
				}
			}
			
		}
		System.out.println("No.# of broken links found on landing page is "+brokenLinksCount);
	}
	
	/*** verifyURLStatus() function accepts URL as parameter & verifies if the response is 200 OK in status line for the HTTP request placed
	 * **/
	public void verifyURLStatus(String url){
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		try {
			HttpResponse response = client.execute(request);
			if(response.getStatusLine().getStatusCode() != 200){
				brokenLinksCount++;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
