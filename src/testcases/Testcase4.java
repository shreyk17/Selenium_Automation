/**
 * 
 */
package testcases;

import java.time.Duration;

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
public class Testcase4 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	@Parameters({ "primary-borrower-base-name1"})
	@Test
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrey\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://nbl.one/");
		
		driver.manage().window().maximize();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id=\"global-search-bar\"]")));
		
		//verifying headers elements
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),\"Quests\")]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),\"Skylifts\")]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),\"Communities\")]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),\"Earnings\")]")).isDisplayed());
		
		//Nbyula icons 
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"hidden h-7 sm:inline\"]")).isDisplayed());
		
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
