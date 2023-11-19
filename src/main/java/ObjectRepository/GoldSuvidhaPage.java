package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoldSuvidhaPage {

	@FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
    @FindBy(xpath="//span[.='Buy Gold']")private WebElement BuyGoldLnk;
	
    @FindBy(xpath="//span[.='Sell Gold']")private WebElement SellGoldLnk;
    
    @FindBy(xpath="//span[.='Transfer Gold']")private WebElement TransferGoldLnk;
    
    @FindBy(xpath="//span[.='Redeem Gold']")private WebElement RedeemGoldLnk;
    
	public GoldSuvidhaPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getBuyGoldLnk() {
		return BuyGoldLnk;
	}

	public WebElement getSellGoldLnk() {
		return SellGoldLnk;
	}

	public WebElement getTransferGoldLnk() {
		return TransferGoldLnk;
	}

	public WebElement getRedeemGoldLnk() {
		return RedeemGoldLnk;
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
