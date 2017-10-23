package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
	protected static WebDriver driver;
	public static Properties common = null;
	private static final Logger LOGGER = Logger.getLogger(Utilities.class.getName());
	public static WebDriverWait wait;
	public static JavascriptExecutor je = null;
	
	public static void setPropertiesFile(){
		common = new Properties();
		try {
			FileInputStream fip= new FileInputStream(System.getProperty("user.dir")+"\\src\\utilities\\common.properties");
			common.load(fip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Properties File Not found at the specified location !! ");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void startBrowser(){
		try{
			setPropertiesFile();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get(common.getProperty("url"));
			wait = new WebDriverWait(driver, 60);
			je = (JavascriptExecutor) driver;
			LOGGER.log(Level.INFO, "Browser started.");
		}catch(Exception e){
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
		
	}

	public static void closeBrowser(){
		driver.quit();
		LOGGER.log(Level.INFO, "Browser closed.");
	}

}
