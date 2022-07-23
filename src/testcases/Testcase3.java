/**
 * 
 */
package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author shrey
 *
 */
public class Testcase3 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	@Parameters({ "primary-borrower-base-name1"})
	@Test
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shrey\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.get("https://nbl.one/listings");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Accommodation']")).click();
		
		driver.findElement(By.xpath("//a[@href='/gigs/category/Accommodation']//button[@type='button']//span[contains(text(),'See all')]")).click();
		
		//List<WebElement> title = driver.findElements(By.xpath("//p[@class=\"text-secondary-200 h-18 break-words text-left font-serif text-base font-semibold -tracking-wider line-clamp-3\"]"));
		
		// all the links present in the webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		//System.out.print(links.size());
		
		for (WebElement webElement : links) {
            String name = webElement.getText();
            System.out.println(name);
        }
		
		//get title
		List<WebElement> title = driver.findElements(By.xpath("//*[@class=\"text-secondary-200 h-18 break-words text-left font-serif text-base font-semibold -tracking-wider line-clamp-3\"]"));
		//System.out.print(title.size());
		for (WebElement webElement1: title) {
            String name1 = webElement1.getText();
            System.out.println(name1);
        }
		
		//get price 
		List<WebElement> price = driver.findElements(By.xpath("//*[@class='font-serif text-xs font-medium -tracking-wider text-secondary-dark-200']"));
		//System.out.println(price.size());
		for (WebElement webElement2 : price) {
            String name2 = webElement2.getText();
            System.out.println(name2);
        }
		
		driver.close();
	}

}
