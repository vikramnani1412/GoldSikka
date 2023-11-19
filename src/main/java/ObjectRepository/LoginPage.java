package ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Finding WebElements Using @FindBy Annotations

    @FindBy(xpath="//input[@placeholder='Email/Phone Number']")private WebElement MobileNumberEdt;
    
    @FindBy(xpath="//button[@class='continue-button']")private WebElement ContinueBtn;
    
    @FindBy(xpath="//button[.=' Login with Google ']")private WebElement LoginWithGoogleBtn;
    
    @FindBy(xpath="//button[.=' Demo Account ']")private WebElement DemoAccountBtn;
	
  
	//Rule-3:Create a constructor to initilise these elements
    
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule-4:Provide getters to access these variables

	public WebElement getMobileNumberEdt() {
		return MobileNumberEdt;
	}


	public WebElement getContinueBtn() {
		return ContinueBtn;
	}


	public WebElement getLoginWithGoogleBtn() {
		return LoginWithGoogleBtn;
	}


	public WebElement getDemoAccountBtn() {
		return DemoAccountBtn;
	}
	
	//Business Libraries
	public void loginToApplication(String USERNAME)
	{
		MobileNumberEdt.sendKeys(USERNAME,Keys.ENTER);
	}
	
	
	
}
