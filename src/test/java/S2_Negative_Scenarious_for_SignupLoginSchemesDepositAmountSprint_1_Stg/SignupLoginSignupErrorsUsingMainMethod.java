package S2_Negative_Scenarious_for_SignupLoginSchemesDepositAmountSprint_1_Stg;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
public class SignupLoginSignupErrorsUsingMainMethod {

	public static void main(String[] args) throws Exception {
		
		SignupLoginSignupErrorsUsingMainMethod err = new SignupLoginSignupErrorsUsingMainMethod();
		
		err.whileSignIntoApplicationExistingEmailGivenErrorTest();
		err.whileSignIntoApplicationExistingPhoneNumberGivenErrorTest();
		err.whileSignIntoApplicationPhoneNumberNotGivenErrorTest();
		err.whileSignIntoApplicationGivenWrongReferralCodeErrorTest();
		err.whileSignIntoApplicationGivenRightReferralCodePassedTest();
		err.whileSignIntoApplicationSkipNameErrorTest();
		err.whileSignIntoApplicationSkipHeardAboutUsDropDwnValueErrorTest();
		err.whileSignIntoApplicationEnterMoreThan10NumbersInMobileNumTextFieldErrorTest();
		err.whileSignIntoApplicationGivenInvalidEmailErrorTest();
		
		
	}
		
		public void whileSignIntoApplicationExistingEmailGivenErrorTest() throws Exception
		 {
			JavaUtility jUtil = new JavaUtility();
			WebDriverUtility wUtil = new WebDriverUtility();
			String methodName = "whileSignIntoApplicationEmailNotGivenErrorTest";
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
			Select s = new Select(AccType);
			s.selectByVisibleText("Personal Account");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("vikram.xyug@gmail.com");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("833"+jUtil.getRandomNum());
			
			Thread.sleep(2000);
			
			WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
			Select ss = new Select(ele);
			ss.selectByVisibleText("Social Media Add");
			
			Thread.sleep(2000);
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("AO6GPM");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
			
			Thread.sleep(2000);
			
			//Email not given error
			try 
			{
				WebElement EmailNotGivenError = driver.findElement(By.xpath("//label[text()='Email ']//following-sibling::div[.='This field is required ']"));
				String EmailNotGivenErrorMsg = EmailNotGivenError.getText();
				if(EmailNotGivenError.isDisplayed())
				{
				   System.out.println("You have not entered E-mail "+EmailNotGivenErrorMsg);
				   wUtil.takeScreenShot(driver, methodName);
				   Thread.sleep(1000);
				   Assert.fail();
				}
			}			
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
			
			
			//Email already existing error
			try 
			{
				WebElement ExistingEmailGivenError = driver.findElement(By.xpath("//label[text()='Email ']/following-sibling::div[.='The email has already been taken.']"));
				String ExistingEmailGivenErrorMsg = ExistingEmailGivenError.getText();
				if(ExistingEmailGivenError.isDisplayed())
				{
				   System.out.println(ExistingEmailGivenErrorMsg);
				   wUtil.takeScreenShot(driver, methodName);
				   Thread.sleep(1000);
				   Assert.fail();
				}
			}
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
			
			driver.quit();
			
		}
		
		 //Given existing phone number error
		
		 public void whileSignIntoApplicationExistingPhoneNumberGivenErrorTest() throws Exception
		 {
			WebDriverUtility wUtil = new WebDriverUtility();
			String methodName = "whileSignIntoApplicationPhoneNumberGivenErrorTest";
			
			JavaUtility jUtil = new JavaUtility();
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
			Select s = new Select(AccType);
			s.selectByVisibleText("Personal Account");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Gvc");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("vikram.xyug"+jUtil.getRandomNum()+"@gmail.com");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8686184458");
			
			Thread.sleep(2000);
			
			WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
			Select ss = new Select(ele);
			ss.selectByVisibleText("Social Media Add");
			
			Thread.sleep(2000);
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("AO6GPM");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			Thread.sleep(2000);
		    
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
			
			Thread.sleep(2000);
			
			//Phone Num not given error
			try
			{
			   WebElement PhoneNumNotGivenError = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']/following-sibling::div[.='This field is required ']"));
		       String PhoneNumNotGivenErrorMsg = PhoneNumNotGivenError.getText();
		       if(PhoneNumNotGivenError.isDisplayed())
		       {
			      System.out.println("You have not entered Phone number "+PhoneNumNotGivenErrorMsg);
			      wUtil.takeScreenShot(driver, methodName);
			      Thread.sleep(1000);
				  Assert.fail();
		       }
			}			
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
			
			//Given existinGiven phone num error
			try
			{
			   WebElement ExistingPhoneNumGivenError = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']//following-sibling::div[.='The mobile has already been taken.']"));
			   String ExistingPhoneNumGivenErrorMsg = ExistingPhoneNumGivenError.getText();
			   if(ExistingPhoneNumGivenError.isDisplayed())
			   {
			      System.out.println(ExistingPhoneNumGivenErrorMsg);
			      wUtil.takeScreenShot(driver, methodName);
			      Thread.sleep(1000);
				  Assert.fail();
			   }
			}
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
		    
			Thread.sleep(3000);
			
			driver.quit();
			
		}
		
		 //Skipped phone number error
		 public void whileSignIntoApplicationPhoneNumberNotGivenErrorTest() throws Exception
		 {
			WebDriverUtility wUtil = new WebDriverUtility();
			String methodName = "whileSignIntoApplicationPhoneNumberNotGivenErrorTest";
			
			JavaUtility jUtil = new JavaUtility();
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
			Select s = new Select(AccType);
			s.selectByVisibleText("Personal Account");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("vikram.xyug"+jUtil.getRandomNum()+"@gmail.com");
			
			Thread.sleep(2000);
			
//			driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8686184458");
			
			WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
			Select ss = new Select(ele);
			ss.selectByVisibleText("Social Media Add");
			
			Thread.sleep(2000);
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("AO6GPM");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
			Thread.sleep(2000);
			
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
			
			Thread.sleep(2000);
			
			//Phone Num skipped error
			try
			{
			   WebElement PhoneNumSkippedError = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']//following-sibling::div[.='This field is required ']"));
		       String PhoneNumSkippedErrorMsg = PhoneNumSkippedError.getText();
		       if(PhoneNumSkippedError.isDisplayed())
		       {
		          System.out.println("You have not entered Phone number "+PhoneNumSkippedErrorMsg);
			      wUtil.takeScreenShot(driver, methodName);
			      Thread.sleep(1000);
				  Assert.fail();
		       }
			}			
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
			
			//Existing phone num error
			try
			{
			   WebElement ExistingPhoneNumGivenError = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']//following-sibling::div[.='The mobile has already been taken.']"));
			   String ExistingPhoneNumGivenErrorMsg = ExistingPhoneNumGivenError.getText();
			   if(ExistingPhoneNumGivenError.isDisplayed())
			   {
			      System.out.println(ExistingPhoneNumGivenErrorMsg);
			      wUtil.takeScreenShot(driver, methodName);
			      Thread.sleep(1000);
				  Assert.fail();
			   }
			}
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
		    
			driver.quit();
			
		}
		
		//Invalid Referral Code
		 public void whileSignIntoApplicationGivenWrongReferralCodeErrorTest() throws Exception
		 {
			WebDriverUtility wUtil = new WebDriverUtility();
			String methodName = "whileSignIntoApplicationGivenWrongReferralCodeErrorTest";
			
			JavaUtility jUtil = new JavaUtility();
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
			Select s = new Select(AccType);
			s.selectByVisibleText("Personal Account");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Gvc");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("vikram.xyug"+jUtil.getRandomNum()+"@gmail.com");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("989"+jUtil.getRandomNum());
			
			Thread.sleep(2000);
			
			WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
			Select ss = new Select(ele);
			ss.selectByVisibleText("Social Media Add");
			
			Thread.sleep(2000);
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("abcd123d");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
			Thread.sleep(2000);
			
			//Given wrong Referral code
			try
			{
			   WebElement WrongReferralCodeError = driver.findElement(By.xpath("//div[text()='Wrong Referral Code']"));
			   String WrongReferralCodeErrorMsg = WrongReferralCodeError.getText();
			   if(WrongReferralCodeError.isEnabled())
			   {
				   System.out.println(WrongReferralCodeErrorMsg);
				   wUtil.takeScreenShot(driver, methodName);
				   Thread.sleep(1000);
				   Assert.fail();
			   }
			}
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
			
			driver.quit();
		}
		
		
		 //Right Referral Code  //Referral Code:-AO6GPM
		 public void whileSignIntoApplicationGivenRightReferralCodePassedTest() throws Exception
		 {
			WebDriverUtility wUtil = new WebDriverUtility();
			String methodName = "whileSignIntoApplicationGivenRightReferralCodePassedTest";
			
			JavaUtility jUtil = new JavaUtility();
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
			Select s = new Select(AccType);
			s.selectByVisibleText("Personal Account");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("vikram.xyug"+jUtil.getRandomNum()+"@gmail.com");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("833"+jUtil.getRandomNum());
			
			Thread.sleep(2000);
			
			WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
			Select ss = new Select(ele);
			ss.selectByVisibleText("Social Media Add");
			
			Thread.sleep(2000);
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("AO6GPM");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
			Thread.sleep(2000);
			
			//Right Referral code
			try
			{
			   WebElement RightReferralCodeOTPpage = driver.findElement(By.xpath("//div[@class='login-box ng-star-inserted']"));
			   String RightReferralCodeMsg = RightReferralCodeOTPpage.getText();
			   if(RightReferralCodeOTPpage.isDisplayed())
			   {
			      System.out.println(RightReferralCodeMsg);
			      wUtil.takeScreenShot(driver, methodName);
			   }
			}
			catch (Exception e) 
			{
				Thread.sleep(3000);
				wUtil.takeScreenShot(driver, methodName);
			    System.out.println(methodName+"--->Failed");
			    Thread.sleep(1000);
				Assert.fail();
			}
			
			driver.quit();
		}
		
		
		 //Skip Name Error   
		 public void whileSignIntoApplicationSkipNameErrorTest() throws Exception
		 {
			WebDriverUtility wUtil = new WebDriverUtility();
			String methodName = "whileSignIntoApplicationSkipNameErrorTest";
			
			JavaUtility jUtil = new JavaUtility();
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
			Select s = new Select(AccType);
			s.selectByVisibleText("Personal Account");
			
			Thread.sleep(2000);
			
//			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
			
			driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("vikram.xyug"+jUtil.getRandomNum()+"@gmail.com");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("886"+jUtil.getRandomNum());
			
			Thread.sleep(2000);
			
			WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
			Select ss = new Select(ele);
			ss.selectByVisibleText("Social Media Add");
			
			Thread.sleep(2000);
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("AO6GPM");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
			Thread.sleep(2000);
			
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
			
			Thread.sleep(1000);
			
					
			//Referral code
			try
			{
			   WebElement SkipNameError = driver.findElement(By.xpath("//label[text()='Name ']/following-sibling::div[.='This field is required ']"));
			   String SkipNameErrorMsg = SkipNameError.getText();
			   if(SkipNameError.isDisplayed())
			   {
			      System.out.println(SkipNameErrorMsg);
			      wUtil.takeScreenShot(driver, methodName);
			      Thread.sleep(1000);
				  Assert.fail();
			   }
			}
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
			
			driver.quit();
			
		}
		
		
		
		 //Skip Heard About Us DropDwn Value Error
		 public void whileSignIntoApplicationSkipHeardAboutUsDropDwnValueErrorTest() throws Exception
		 {
			WebDriverUtility wUtil = new WebDriverUtility();
			String methodName = "whileSignIntoApplicationSkipHeardAboutUsDropDwnValueErrorTest";
			
			JavaUtility jUtil = new JavaUtility();
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
			Select s = new Select(AccType);
			s.selectByVisibleText("Personal Account");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Ramakrishna");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("vikram.xyug"+jUtil.getRandomNum()+"@gmail.com");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("987"+jUtil.getRandomNum());
			
			Thread.sleep(2000);
			
//			WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
//			Select ss = new Select(ele);
//			ss.selectByVisibleText("Social Media Add");
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("AO6GPM");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
			Thread.sleep(2000);
			
			//Referral code
			try
			{
			   WebElement SkipHeardAboutUsError = driver.findElement(By.xpath("//label[text()='Heard About Us ']/following-sibling::div[.='This field is required ']"));
			   String SkipHeardAboutUsErrorMsg = SkipHeardAboutUsError.getText();
			   
			   System.out.println("You did not select how you heard about us You have to select a Value from drop down"+SkipHeardAboutUsErrorMsg);
		       wUtil.takeScreenShot(driver, methodName);
		       Thread.sleep(1000);
			   Assert.fail();
			   
//			   if(SkipHeardAboutUsError.isDisplayed())
//			   {
//			       System.out.println("You did not select how you heard about us You have to select a Value from drop down"+SkipHeardAboutUsErrorMsg);
//			       wUtil.takeScreenShot(driver, methodName);
//			       Thread.sleep(1000);
//				   Assert.fail();
//			   }
			}
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
			
			driver.quit();
		}
		
		 //More Than 10 Numbers In Mobile Num
		 public void whileSignIntoApplicationEnterMoreThan10NumbersInMobileNumTextFieldErrorTest() throws Exception
		 {
			WebDriverUtility wUtil = new WebDriverUtility();
			String methodName = "whileSignIntoApplicationEnterMoreThan10NumbersInMobileNumTextFieldErrorTest";
			
			JavaUtility jUtil = new JavaUtility();
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
			Select s = new Select(AccType);
			s.selectByVisibleText("Personal Account");
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Gvc");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("vikram.xyug"+jUtil.getRandomNum()+"@gmail.com");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("9906293668709");
			
			Thread.sleep(2000);
			
			WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
			Select ss = new Select(ele);
			ss.selectByVisibleText("Social Media Add");
			
			Thread.sleep(2000);
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("AO6GPM");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
			Thread.sleep(2000);
			
			//More Than 10 Numbers giving as Mobile Number
			try
			{
			   WebElement enteringMoreThan10NumbersInSMobileNumberField = driver.findElement(By.xpath("//label[text()='Mobile Number (+91)']/following-sibling::div[.='Please Enter 10 digits number ']"));
			   String enteringMoreThan10NumbersInMobileNumberFieldMsg = enteringMoreThan10NumbersInSMobileNumberField.getText();
			   if(enteringMoreThan10NumbersInSMobileNumberField.isDisplayed())
			   {
				   System.out.println(enteringMoreThan10NumbersInMobileNumberFieldMsg);
				   wUtil.takeScreenShot(driver, methodName);
				   Thread.sleep(1000);
				   Assert.fail();
			   }
			}
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
			
			driver.quit();
		}
		
		
		 //Giving Invalid email error
		 public void whileSignIntoApplicationGivenInvalidEmailErrorTest() throws Exception     //Not giving @gmail.com
		 {
			WebDriverUtility wUtil = new WebDriverUtility();
			String methodName = "whileSignIntoApplicationGivenInvalidEmailErrorTest";
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://stg-new-wallet.goldsikka.com/");
			driver.findElement(By.xpath("//a[.='Sign Up']")).click();
			WebElement AccType  = driver.findElement(By.xpath("//select[@formcontrolname='roleType']"));
			Select s = new Select(AccType);
			s.selectByVisibleText("Personal Account");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys("Gvc");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("pavanikaka");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']")).sendKeys("8331827873");
			
			Thread.sleep(2000);
			
			WebElement ele = driver.findElement(By.xpath("//select[@formcontrolname='heard_us']"));
			Select ss = new Select(ele);
			ss.selectByVisibleText("Social Media Add");
			
			Thread.sleep(2000);
			
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			driver.findElement(By.xpath("//input[@placeholder='Enter your referral code']")).sendKeys("");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyRelease(KeyEvent.VK_PAGE_UP);
			
			Thread.sleep(2000);
			
			//Email skipped error
			try 
			{
				WebElement SkippedEmailError = driver.findElement(By.xpath("//label[text()='Email ']//following-sibling::div[.='This field is required ']"));
				String SkippedEmailErrorMsg = SkippedEmailError.getText();
				if(SkippedEmailError.isDisplayed())
				{
				   System.out.println("You have not entered Incorrect E-mail "+SkippedEmailErrorMsg);
				   wUtil.takeScreenShot(driver, methodName);
				}
			}			
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
			
			//Given invalid email error
			try 
			{
				WebElement GivenInvalidEmailError = driver.findElement(By.xpath("//label[text()='Email ']/following-sibling::div[.='Please Enter Correct Email ']"));
				String InvalidEmailGivenErrorMsg = GivenInvalidEmailError.getText();
				if(GivenInvalidEmailError.isDisplayed())
				{
				   System.out.println("You have not entered Correct E-mail "+InvalidEmailGivenErrorMsg);
				   wUtil.takeScreenShot(driver, methodName);
				}
			}
			catch (Exception e) 
			{
				Thread.sleep(1);
			}
			
			driver.quit();
			
		}

	}


