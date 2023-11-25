package ObjectRepository;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.WebDriverUtility;

public class DashboardPage extends WebDriverUtility{//Rule-1:Create a seperate class for every webpage

    //Rule-2:Identify the elements using @FindBy annotations
	
	@FindBy(xpath="//ul[@class='user-nav ng-tns-c39-0']/li/following-sibling::li//span[.='admin']")private WebElement AdminLnk;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/power (2) 1.png']")private WebElement PowerBtn;
	
//	@FindBy(xpath="(//div[@class='col-md-6 second-row-col-six-two ng-tns-c50-1']/div//button[@class='btn mt-3 ng-tns-c50-1'])[4]")private WebElement SchemeSubriptionPowerBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Heart.png']")private WebElement WishlistBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Buy.png']")private WebElement CartBtn;
	
	@FindBy(xpath="//img[@src='../../../assets/imgs/Notification.png']")private WebElement NotificationBtn;
	
	@FindBy(xpath="//p[.='Buy Gold']")private WebElement BuyGoldLnk;
	
	@FindBy(xpath="//p[.='Sell Gold']")private WebElement SellGoldLnk;
	
	@FindBy(xpath="//p[.='Transfer Gold']")private WebElement TransferGoldLnk;
	
	@FindBy(xpath="//p[.='Redeem Gold']")private WebElement RedeemGoldLnk;
	
	@FindBy(xpath="//button[.='deposit']")private WebElement DepositBtn;
	
	@FindBy(xpath="//button[.='withdraw']")private WebElement WithdrawBtn;
	
	@FindBy(xpath="//a[.='View all transactions']")private WebElement ViewAllTransactionsLnk;
	
	//Rule-3:Create a constructor to initilise these elements
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Rule-4:Provide getters to access these variables
	
	public WebElement getPowerOffBtn() {
		return PowerBtn;
	}

	public WebElement getAdminLnk() {
		return AdminLnk;
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

	public WebElement getDepositBtn() {
		return DepositBtn;
	}

	public WebElement getWithdrawBtn() {
		return WithdrawBtn;
	}

	public WebElement getViewAllTransactionsLnk() {
		return ViewAllTransactionsLnk;
	}
	
	//Business Library - To optimize the test script
	/**
	 * This Method will click on Org link
	 * @throws Exception 
	 */
	public void logoutOfApplication(WebDriver driver) throws Exception
	{	
		
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(100)) 
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
	    fluentWait.until(ExpectedConditions.visibilityOf(PowerBtn));
		PowerBtn.click();
		driver.switchTo().alert().accept();
		

	}
    
	 /**
	 * This Method will click on Admin link
	 */
	public void clickOnAdminLnk()
	{
		AdminLnk.click();
	}
	
//	public void schemesSubscriptionLogoutOfApplication(WebDriver driver)
//	{	
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click()",SchemeSubriptionPowerBtn);
//		driver.switchTo().alert().accept();
//	}

}
 