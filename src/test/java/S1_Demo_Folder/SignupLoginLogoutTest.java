	package S1_Demo_Folder;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
	

	public class SignupLoginLogoutTest {

		 @Test(groups = "Signup" , priority = 1)
		 public void signIntoApplication() throws Exception
		 {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			
			Thread.sleep(3000);
			
			WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
			Select s = new Select(AccType);
			s.selectByVisibleText("Personal Account");
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("ramakrishna@gmail.com");
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8686184458");
			
			Thread.sleep(3000);
			
			WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
			Select ss = new Select(ele);
			ss.selectByVisibleText("Social Media Add");
			
			Thread.sleep(3000);
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("Not Given");
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
            
			
		}		
			
			@Test(groups = "Login" , priority = 2)
			public void loginToApplication() throws InterruptedException
			{
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://stg-new-wallet.goldsikka.com/");
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("9100345025",Keys.ENTER);
				
				
			}
						
			
			@Test(groups = "Logout" , priority = 3)
			public void logoutOfApplication() throws InterruptedException
			{
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get("https://stg-new-wallet.goldsikka.com/");
				
				Thread.sleep(3000);
				
				driver.findElement(By.xpath("//input[@placeholder='Email/Phone Number']")).sendKeys("9100345025",Keys.ENTER);
				
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//div[@class='col-md-6 my-second-col-six ng-tns-c50-1']//ancestor::div[@class='col-md-6 second-row-col-six-two ng-tns-c50-1']//button[@class='btn mt-3 ng-tns-c50-1']//img[@src='../../../assets/imgs/power (2) 1.png']")).click();
				
				Thread.sleep(3000);
				
				driver.switchTo().alert().accept();
				
				Thread.sleep(3000);
			}
		
			
}
	       
	       