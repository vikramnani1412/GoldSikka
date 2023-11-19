package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_AccountsPage {

    @FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
    
    @FindBy(xpath="//input[@placeholder='Enter Name']")private WebElement NameEdt;
    
    @FindBy(xpath="//input[@placeholder='Enter Your Email']")private WebElement EmailEdt;
    
    @FindBy(xpath="//input[@placeholder='Enter Your Mobile Number']")private WebElement MobileNoEdt;
    
    @FindBy(xpath="//div[.='Submit']")private WebElement SubmitBtn;
    
    
	public Settings_AccountsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getPowerBtn() {
		return PowerBtn;
	}


	public WebElement getWishlistBtn() {
		return WishlistBtn;
	}


	public WebElement getCartBtn() {
		return CartBtn;
	}


	public WebElement getNotificationBtn() {
		return NotificationBtn;
	}


	public WebElement getNameEdt() {
		return NameEdt;
	}


	public WebElement getEmailEdt() {
		return EmailEdt;
	}


	public WebElement getMobileNoEdt() {
		return MobileNoEdt;
	}


	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	
}
