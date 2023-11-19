package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Events_EventsPage {

	@FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
    @FindBy(xpath="//button[.='Create Event']")private WebElement CreateEventBtn;
    
	public Events_EventsPage(WebDriver driver)
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



	public WebElement getCreateEventBtn() {
		return CreateEventBtn;
	}
	
	
}
