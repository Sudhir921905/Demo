import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		String URL= "http://qatechhub.com";
		String URL2="https://www.facebook.com";
		String Title= "QA Automation Tools Trainings and Tutorials | QA Tech Hub";
		
		System.setProperty("webdriver.chrome.driver", "D://java//Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		String getURL= driver.getTitle();
		if(getURL == Title)
		{
			System.out.println("Title Matched");
		}
		else
		{
			System.err.println();
		}
		
		driver.navigate().to(URL2);
		driver.navigate().back();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		

	}

}
