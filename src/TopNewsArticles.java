import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TopNewsArticles {

	public static WebDriver driver;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		setBrowser();
		verifyTopNewsArticle();
		teardown();
		

	}
	
	private static void teardown() {
		// TODO Auto-generated method stub
		
		driver.quit();
	}

	public static void setBrowser(){
		
		System.setProperty("webdriver.chrome.driver", "D://java//Driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://economictimes.indiatimes.com");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void verifyTopNewsArticle() {
		
        String pWindow= driver.getWindowHandle();
		List<WebElement> ele=driver.findElements(By.xpath("//li[@data-ga-action= 'Widget Top News']/ul/li/a"));
		for(WebElement ele1 : ele) {
			//System.out.println(ele1.getAttribute("href"));
			ele1.click();
			Set<String> allWind=driver.getWindowHandles();
			Iterator<String> itr= allWind.iterator();
			while(itr.hasNext()) {
				String cWindows=driver.getWindowHandle();
				if(cWindows.equalsIgnoreCase(pWindow)) {
					driver.switchTo().window(itr.next());
					System.out.println(driver.getCurrentUrl());
					teardown();
					driver.switchTo().window(pWindow);
				}
			}
			
			
			
			
			
			
			
			
			
			System.out.println(driver.getTitle());
			WebElement ArticleHeadline= driver.findElement(By.xpath("//h1[@class ='artTitle font_faus']"));
			System.out.println("Article Headline is:- "+ ArticleHeadline.getText());
		}
		
	}
	
	
}
