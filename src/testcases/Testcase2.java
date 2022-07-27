/**
 * 
 */
package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author shrey
 *
 */
public class Testcase2 {

	/**
	 * @param args
	 */
	@Parameters({ "primary-borrower-base-name1"})
	@Test
	public void testcase2() {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrey\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://nby.la/rdJuXp");
		
		driver.manage().window().maximize();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='font-sans text-2xl font-bold text-secondary']")));
		
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//button[@id=\"skylift-book-seat\"]")).isDisplayed());
			
			driver.findElement(By.xpath("//button[@id=\"skylift-book-seat\"]")).click();
			
			driver.switchTo().defaultContent();
			
			Thread.sleep(1000);
			
			//login condition
			if(driver.findElements(By.xpath("//button[@id='login-modal-continue-with-email']")).size()>0) {
				System.out.println("inside if");
				driver.findElement(By.xpath("//button[@id='login-modal-continue-with-email']")).click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type=\"email\"]")));
				
				driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("shreyk.11@gmail.com");
				
				driver.findElement(By.xpath("//button[@id = \"login-custom\"]")).click();
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type=\"password\"]")));
				
				Assert.assertFalse(driver.findElement(By.xpath("//button[@id = \"login-custom\"]")).isEnabled());
				
				driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("shrey1701");
				
				driver.findElement(By.xpath("//button[@id='login-custom']")).click();
				
				System.out.println("button clicked");
				
			}
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"gig-booking-flow\"]")));
			
			Thread.sleep(1000);
			
			//check if already enrolled for the program
			if(driver.findElements(By.xpath("(//span[contains(text(),'Join Conversation with Careers@Nbyula')])[1]")).size()>0) {
				System.out.println("already enrolled");
			}else {
			
				Assert.assertTrue(driver.findElement(By.xpath("//button[@id=\"skylift-proceed-to-purchase\"]")).isEnabled());
				
				driver.findElement(By.xpath("//button[@id=\"skylift-proceed-to-purchase\"]")).click();
				
				System.out.println("proceed button clicked");
				
				Thread.sleep(1000);
				
				//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='continue-to-pay-zero-dollar']")));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Billing State']")));
				
				String s1 = driver.findElement(By.xpath("//h1[@class='font-sans text-2xl font-bold tracking-tight text-secondary']")).getText();
				
				System.out.println(s1);
				
				String s2 = driver.findElement(By.xpath("//p[@class='font-serif text-sm font-normal tracking-tight text-secondary-dark-200']")).getText();
				
				System.out.println(s2);
				
				//Assertion for basic price , platform fee and tax is displayed
				Assert.assertTrue(driver.findElement(By.xpath("//section[@class='flex flex-col space-y-1.5']")).isDisplayed());
				
				//Assertion for dropdowns
				Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Billing Country']")).isDisplayed());
	
				Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Billing State']")).isDisplayed());
				//driver.findElement(By.xpath("//p[normalize-space()='Billing State']")).getAttribute("clickable").equals(true);
				
				driver.findElement(By.xpath("//p[normalize-space()='Billing State']")).click();
				Thread.sleep(1000);
				
				//selecting a state from dropdown
				WebElement e = driver.findElement(By.xpath("//button[normalize-space()='Chattisgarh']"));
				
				Actions a = new Actions(driver);
				a.moveToElement(e);
				a.perform();
				
				System.out.println("scrolled to element");
				
				driver.findElement(By.xpath("//button[normalize-space()='Chattisgarh']")).click();
				
				Assert.assertTrue(driver.findElement(By.xpath("//button[@id='continue-to-pay-zero-dollar']")).isDisplayed());
				driver.findElement(By.xpath("//button[@id='continue-to-pay-zero-dollar']")).click();
				
				Thread.sleep(1000);
				
				Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Send booking confirmation to']")).isDisplayed());
							
				driver.findElement(By.xpath("//input[@placeholder='1 (702) 123-4567']")).sendKeys("1234567891");
				
				Assert.assertTrue(driver.findElement(By.xpath("//input[@type=\"checkbox\"][@class=\"sr-only\"]")).isDisplayed());
				
				Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Continue']")).isDisplayed());
				
				driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
				
				Thread.sleep(1000);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		
		driver.close();
	}

}
