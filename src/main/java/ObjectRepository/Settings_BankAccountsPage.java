package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_BankAccountsPage {

    @FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
    
    @FindBy(xpath="//a[@href='/settings/bankAccounts/add']")private WebElement AddNewBankAccBtn;
    
    @FindBy(xpath="///p[.='21468966465489']/../following-sibling::div//a[.='Set Default']")private WebElement SetDefaultAccBasedObnAcNum;
    
    //Upto Just making default
    //Pending DELETE,EDT,DELETE
    
	public Settings_BankAccountsPage(WebDriver driver)
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

	public WebElement getAddNewBankAccBtn() {
		return AddNewBankAccBtn;
	}

	public WebElement getSetDefaultAccBasedObnAcNum() {
		return SetDefaultAccBasedObnAcNum;
	}
	
	

}
