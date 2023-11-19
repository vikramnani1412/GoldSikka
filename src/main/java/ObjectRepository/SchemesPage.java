package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchemesPage {

    @FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/goldplus.png']")private WebElement SubscribeBtn;
	
	@FindBy(xpath="//table[@class='table']")private WebElement SchemesTable;
	
	@FindBy(xpath="//li[@class='pagination-next ng-star-inserted disabled']")private WebElement NextBtn;
	
	@FindBy(xpath="//a[@aria-label='Previous page']")private WebElement PreviousBtn;
	
	
	public SchemesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//Getters
	
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


	public WebElement getSubscribeBtn() {
		return SubscribeBtn;
	}


	public WebElement getSchemesTable() {
		return SchemesTable;
	}


	public WebElement getNextBtn() {
		return NextBtn;
	}


	public WebElement getPreviousBtn() {
		return PreviousBtn;
	}
	
	//Business Library
	
	public void subscribeAScheme()
	{
		SubscribeBtn.click();
	}
	
	
	
	
}
