package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoldSuvidhaRedeemGoldPage {

	@FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
	@FindBy(xpath="//input[@placeholder='Enter grams']")private WebElement QuantityTxt;
	
	@FindBy(xpath="//input[@type='checkbox']")private WebElement UseBookingAccCheckBox;
	
	@FindBy(xpath="//input[@placeholder='Enter amount']")private WebElement EnterAmtTxt;
	
	@FindBy(xpath="//button[.='Continue']")private WebElement ContinueBtn;
	
	//Upto Continue Done
	
	public GoldSuvidhaRedeemGoldPage(WebDriver driver)
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



	public WebElement getQuantityTxt() {
		return QuantityTxt;
	}



	public WebElement getUseBookingAccCheckBox() {
		return UseBookingAccCheckBox;
	}



	public WebElement getEnterAmtTxt() {
		return EnterAmtTxt;
	}



	public WebElement getContinueBtn() {
		return ContinueBtn;
	}
	
	
}
