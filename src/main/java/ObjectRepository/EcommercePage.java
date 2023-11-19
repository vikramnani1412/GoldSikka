package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EcommercePage {

	@FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
    @FindBy(xpath="//span[.='Home']")private WebElement HomeLnk;
	
	@FindBy(xpath="//span[.='Favourites']")private WebElement FavouritesLnk;
	
	@FindBy(xpath="//span[.='cartpage']")private WebElement CartpageLnk;
	
	@FindBy(xpath="//span[.='myorder']")private WebElement MyOrderLnk;
    
	public EcommercePage(WebDriver driver)
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

	public WebElement getHomeLnk() {
		return HomeLnk;
	}

	public WebElement getFavouritesLnk() {
		return FavouritesLnk;
	}

	public WebElement getCartpageLnk() {
		return CartpageLnk;
	}

	public WebElement getMyOrderLnk() {
		return MyOrderLnk;
	}

		
	
	
}
