package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PassbookPage {

    @FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
	@FindBy(xpath="//select[@formcontrolname='type']")private WebElement TransactionTypeDrpDwn;
    
    @FindBy(xpath="//select[@formcontrolname='type']/ancestor::div/following-sibling::div[@class='container-fluid']")private WebElement TransactionHystoryListTable;
    
    @FindBy(xpath="//li[@class='pagination-previous disabled ng-star-inserted']")private WebElement PreviousLnk;
    
    @FindBy(xpath="//a[@aria-label='Next page']")private WebElement NextLnk;
    
//  698006181293066170=Dynamic need to store in a variable
    @FindBy(xpath="//td[.='698006181293066170']/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td")private WebElement DownloadParticularTransactionReport;
    
    
	public PassbookPage(WebDriver driver)
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


	public WebElement getTransactionTypeDrpDwn() {
		return TransactionTypeDrpDwn;
	}


	public WebElement getTransactionHystoryListTable() {
		return TransactionHystoryListTable;
	}


	public WebElement getPreviousLnk() {
		return PreviousLnk;
	}


	public WebElement getNextLnk() {
		return NextLnk;
	}


	public WebElement getDownloadParticularTransactionReport() {
		return DownloadParticularTransactionReport;
	}

	
	
	
	
	
}
