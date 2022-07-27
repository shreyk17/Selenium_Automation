/**
 * 
 */
package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author shrey
 *
 */
//@Parameters({ "primary-borrower-base-name1", "primary-borrower-base-name" })
//@Test
public class Testcase1 {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")	
	@Parameters({ "primary-borrower-base-name1"})
	@Test
	public void testcase1() {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrey\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://nbl.one/");
		
		driver.manage().window().maximize();
		
		//assertEquals(System.getProperty("https://nbl.one/"), "https://nbl.one/");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"global-search-bar\"]")));
		
		try {
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id,'quest-card')]")));
			//assertion for quest card
			assertTrue(driver.findElement(By.xpath("//*[contains(@id,'quest-card')]")).isDisplayed());
			
			//assertion for heading of the quest.
			assertTrue(driver.findElement(By.xpath("//*[@class=\"flex space-x-4 md:space-x-18\"]")).isDisplayed());
			
			String header = driver.findElement(By.xpath("//*[@class=\"flex space-x-4 md:space-x-18\"]")).getText();
			System.out.println(header);
			
			if(driver.findElements(By.xpath("//span[contains(text(),'Continue Reading')]")).size()>0) {
				System.out.println("Continue read link is available");
			}else {
				System.out.println("Continue read link is not available");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		
		driver.close();
		
	}

}
