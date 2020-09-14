import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	
	
	WebElement firstName, surName, emailID,ReemailID, newPassword, genderMale, genderFemale, genderOthers, DOB, signUP;
	WebDriver driver;
	String facebookURL= "https://www.facebook.com/";
	Select birthday_Day;
	
	
	
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D://java//Driver/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(facebookURL);
		setBrowser();
		driver.close();
		
	}
	
	public void setBrowser() {
		// TODO Auto-generated method stub
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.MILLISECONDS);
		fbSignUp();
		
		
	}

	public void fbSignUp() 
	{
		 firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("ET");
		
		surName =driver.findElement(By.xpath("//input[@name= 'lastname']"));
		surName.sendKeys("QA");
		
		emailID= driver.findElement(By.xpath("//input[@name='reg_email__']"));
		emailID.sendKeys("sudhir.921905@gmail.com");
		
		ReemailID=driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
		ReemailID.sendKeys("sudhir.921905@gmail.com");
		
		newPassword=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		newPassword.sendKeys("sandy@123");
		
		birthday_Day=new Select( driver.findElement(By.name("birthday_day")));
		birthday_Day.selectByValue("5");
		
		Select birthday_month= new Select(driver.findElement(By.name("birthday_month")));
		birthday_month.selectByValue("10");
		
		Select birthday_Year= new Select (driver.findElement(By.name("birthday_year")));
		birthday_Year.selectByValue("1989");
		
		genderFemale=driver.findElement(By.id("u_0_6"));
		genderMale=driver.findElement(By.id("u_0_7"));
		genderMale.click();
		
		genderOthers=driver.findElement(By.id("u_0_8"));
		
		
		signUP=driver.findElement(By.xpath("//button[@name='websubmit']"));
		signUP.click();
		
		
		
	
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment2 as2=new Assignment2();
		as2.launchBrowser();
		System.out.println("sucessfully");

	}

}
