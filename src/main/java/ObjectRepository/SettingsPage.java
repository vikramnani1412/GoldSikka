package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

@FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
	@FindBy(xpath="//a[@class='list-group-item list-group-item-action active']")private WebElement AccountLnk;
	
	@FindBy(xpath="//a[@class='list-group-item list-group-item-action active']")private WebElement KYCLnk;
	
	@FindBy(xpath="//a[@class='list-group-item list-group-item-action active']")private WebElement NomineeDetailsLnk;
	
	@FindBy(xpath="//a[@class='list-group-item list-group-item-action active']")private WebElement AddressesLnk;
	
	@FindBy(xpath="//a[@class='list-group-item list-group-item-action active']")private WebElement BankAccountsLnk;
	
    
	public SettingsPage(WebDriver driver)
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


	public WebElement getAccountLnk() {
		return AccountLnk;
	}


	public WebElement getKYCLnk() {
		return KYCLnk;
	}


	public WebElement getNomineeDetailsLnk() {
		return NomineeDetailsLnk;
	}


	public WebElement getAddressesLnk() {
		return AddressesLnk;
	}


	public WebElement getBankAccountsLnk() {
		return BankAccountsLnk;
	}
	
	
}
