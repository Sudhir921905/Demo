import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeaderTest {
	
	public static void main(String args[]) {
	
	WebDriver driver;
	
	System.setProperty("webdriver.chrome.driver", "D://java//Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://economictimes.indiatimes.com/industry/telecom/telecom-news/indian-court-halts-insolvency-proceedings-against-reliances-anil-ambani/articleshow/77781586.cms");
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	System.out.println(driver.getTitle());
	WebElement ArticleHeadline= driver.findElement(By.xpath("//h1[@class ='artTitle font_faus']"));
	System.out.println("Article Headline is:- "+ ArticleHeadline.getText());
	
	WebElement ArticleSynopsis= driver.findElement(By.xpath("//h2[@class = 'summary']"));		
	System.out.println("Article Synopsis is:- " +ArticleSynopsis.getText());
	
	 
	WebElement facebookSharing= driver.findElement(By.xpath(""));
	
	
	
	
	driver.quit();
	
}}
