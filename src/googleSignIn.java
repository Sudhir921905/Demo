import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class googleSignIn {

	public static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "D://java//Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://economictimes.indiatimes.com/");
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement signin_link = driver.findElement(By.xpath("//a[@class='signInLink']"));
		signin_link.click();	
		String pWindow= driver.getWindowHandle();
		
		
		WebElement	 Signin_google_link=driver.findElement(By.xpath("//span[contains (text(),'Sign in with Google')]"));
		Signin_google_link.click();
		
		
		Set<String> winID=driver.getWindowHandles();
		
		Iterator<String> itr = winID.iterator();
		
		while (itr.hasNext()) {
			
			String s=itr.next();	
			if(s.equalsIgnoreCase(pWindow)) {
				driver.switchTo().window(itr.next());
				login();
				System.out.println("login Sucessfull");
			}
			else {
				login();
			}	
		}
	}	
	
	public static void login() throws Exception {
		WebElement Username_goggle= driver.findElement(By.xpath("//input[@type='email']"));
		Username_goggle.sendKeys("et30092019@gmail.com");
				
		WebElement Username_Click = driver.findElement(By.xpath("//span[contains (text(),'Next')]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", Username_Click);
		

		WebElement Password_google= driver.findElement(By.xpath("//input[@type='password']"));
		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		jse1.executeScript("arguments[0].value='Times@1234' ", Password_google);
		
		
		WebElement Password_Next= driver.findElement(By.xpath(" //span[contains (text(),'Next')]"));
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].click()", Password_Next);

		Thread.sleep(3000);
		
		driver.quit();
	}

}
