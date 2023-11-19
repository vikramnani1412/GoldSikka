package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoldSuvidhaSellGoldPage {

	@FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
	@FindBy(xpath="//input[@placeholder='Enter grams']")private WebElement QuantityTxt;
	
	@FindBy(xpath="//select[@formcontrolname='transferTo']")private WebElement AmountTransferToDrpDwn;
	
	@FindBy(xpath="//button[.='Continue']")private WebElement ContinueBtn;
	
	//Upto Continue done
	
	public GoldSuvidhaSellGoldPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getQuantityTxt() {
		return QuantityTxt;
	}

	public WebElement getAmountTransferToDrpDwn() {
		return AmountTransferToDrpDwn;
	}

	public WebElement getContinueBtn() {
		return ContinueBtn;
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
	
	
	
}
