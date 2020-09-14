import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ETLoginPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver;
		
		
		System.setProperty("webdriver.chrome.driver", "D://java//Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://economictimes.indiatimes.com");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement SignInLink= driver.findElement(By.xpath("//a[contains (text(),'Sign In')]"));
		SignInLink.click();
		
		System.out.println(driver.getTitle());
		
		WebElement SignInWithEmailLink= driver.findElement(By.xpath("//span[contains (text(),'Sign in with Email or Mobile')]"));
		SignInWithEmailLink.click();
		
		WebElement EmailID = driver.findElement(By.xpath("//label[contains(text(),'Enter your Email ID or Mobile No.')]/preceding::input[@class='lg_input lg_email']"));
		EmailID.sendKeys("12aug@groupbuff.com");
		
		WebElement ConitnueEmailID = driver.findElement(By.xpath("//label[contains(text(),'Enter your Email ID or Mobile No.')]//parent::div/following-sibling::div/input[@value=\"Continue\"]"));
		ConitnueEmailID.click();
		
		
		WebElement Password= driver.findElement(By.xpath("//label[contains(text(),'Password')]//preceding-sibling::input[@class='lg_input lg_pwd']"));
		Password.sendKeys("times@123");
		
		WebElement ContinueLink = driver.findElement(By.xpath("//span[contains(text(), 'Change Email ID or Mobile No.')]//parent::div/preceding-sibling::div/input [@type='submit']"));
		ContinueLink.click();
		
		driver.quit();
		
	}

}
