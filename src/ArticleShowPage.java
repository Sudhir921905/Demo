import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ArticleShowPage
{
	public static void main(String args[])
	{
		WebDriver driver;
		
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "D://java//Driver/chromedriver.exe");
		driver = new ChromeDriver(ops);
		driver.get("https://economictimes.indiatimes.com");
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
		WebElement ClickonNews= driver.findElement(By.xpath("//a[@href= 'https://economictimes.indiatimes.com/news']"));
	    ClickonNews.click();
		
		List<WebElement>NewsList=driver.findElements(By.xpath("//section[@class = 'flr halfWidth']/article/h4/a"));
		System.out.println(NewsList.size());
		
		for(int i=1;i<=NewsList.size();i++) {
			
			
			
			Iterator<WebElement> newslist= NewsList.iterator();
			
			while(newslist.hasNext()) {
				
				newslist.next();
				//System.out.println(newslist.next().getAttribute("href"));
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.quit();
		
	}
}