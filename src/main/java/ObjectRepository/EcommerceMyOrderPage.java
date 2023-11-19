package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommerceMyOrderPage {

	long orderid = 6934603233l;


	
	@FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
    //Identified xpath from order id to identify particular id make dynamic
    @FindBy(xpath="//p[.='6934603233']/../../../../following-sibling::div//button[@class='invoice-button']")private WebElement InvoiceBtn;
    
    @FindBy(xpath="//p[.='6934603233']/../../../../following-sibling::div//button[@class='track-button']")private WebElement TrackYourOrderBtn;
    
    @FindBy(xpath="//p[.='6934603233']/../../../../following-sibling::div//button[@class='info']")private WebElement InfoBtn;
    //Identified xpath from order id to identify particular id make dynamic
    
	public EcommerceMyOrderPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public long getOrderid() {
		return orderid;
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

	public WebElement getInvoiceBtn() {
		return InvoiceBtn;
	}

	public WebElement getTrackYourOrderBtn() {
		return TrackYourOrderBtn;
	}

	public WebElement getInfoBtn() {
		return InfoBtn;
	}
	
	
	
}
